"use strict";

//INIT MAPBOX
mapboxgl.accessToken = mapBoxAPIkey;

navigator.geolocation.getCurrentPosition(locationSuccess, locationError, {enableHighAccuracy: true})

function locationSuccess(position) {
    setupMap([position.coords.longitude, position.coords.latitude]);
}

function locationError(error) {
    console.log(error);
}

function setupMap(center) {
    let map = new mapboxgl.Map(
        {
            container: "map",
            style: 'mapbox://styles/mapbox/outdoors-v11',
            center: center,
            zoom: 11,
        });

    //directions request
    async function getRoute(end) {
        const query = await fetch(
            `https://api.mapbox.com/directions/v5/mapbox/walking/${center[0]},${center[1]};${end[0]},${end[1]}?steps=true&geometries=geojson&access_token=${mapBoxAPIkey}`,
            {method: 'GET'}
        );
        const json = await query.json();
        const data = json.routes[0];
        const route = data.geometry.coordinates;
        const geojson = {
            type: 'Feature',
            properties: {},
            geometry: {
                type: 'LineString',
                coordinates: route
            }
        };

        if (map.getSource('route')) {
            map.getSource('route').setData(geojson);
        }

        else {
            map.addLayer({
                id: 'route',
                type: 'line',
                source: {
                    type: 'geojson',
                    data: geojson
                },
                layout: {
                    'line-join': 'round',
                    'line-cap': 'round'
                },
                paint: {
                    'line-color': '#3887be',
                    'line-width': 5,
                    'line-opacity': 0.75
                }
            });
        }
    }

    async function getRouteWithInstructions(end) {
        const query = await fetch(
            `https://api.mapbox.com/directions/v5/mapbox/walking/${center[0]},${center[1]};${end[0]},${end[1]}?steps=true&geometries=geojson&access_token=${mapBoxAPIkey}`,
            {method: 'GET'}
        );
        const json = await query.json();
        const data = json.routes[0];
        const route = data.geometry.coordinates;
        const geojson = {
            type: 'Feature',
            properties: {},
            geometry: {
                type: 'LineString',
                coordinates: route
            }
        };

        if (map.getSource('route')) {
            map.getSource('route').setData(geojson);
        }

        else {
            map.addSource('LineString', {
                'type': 'geojson',
                'data': geojson
            });

            map.addLayer({
                id: 'route',
                type: 'line',
                source: 'LineString',
                layout: {
                    'line-join': 'round',
                    'line-cap': 'round'
                },
                paint: {
                    'line-color': '#3887be',
                    'line-width': 5,
                    'line-opacity': 0.65
                }
            });
        }

        const instructions = document.getElementById('instructions');
        const steps = data.legs[0].steps;

        let tripInstructions = '';
        for (const step of steps) {
            tripInstructions += `<li>${step.maneuver.instruction}</li>`;
        }

        instructions.innerHTML = `<h3>Trip duration: ${Math.floor(
            data.duration / 60
        )} min 🚶🏽 </h3><ol>${tripInstructions}</ol>`;
    }

    map.on('load', () => {
        $('.loading-screen').fadeOut()

        // initial directions request
        getRoute(center);

        // Add starting point to the map
        map.addLayer({
            id: 'point',
            type: 'circle',
            source: {
                type: 'geojson',
                data: {
                    type: 'FeatureCollection',
                    features: [
                        {
                            type: 'Feature',
                            properties: {},
                            geometry: {
                                type: 'Point',
                                coordinates: center
                            }
                        }
                    ]
                }
            },
            paint: {
                'circle-radius': 10,
                'circle-color': '#3887be'
            }
        });

        map.on('click', (event) => {
            const coords = Object.keys(event.lngLat).map((key) => event.lngLat[key]);
            const end = {
                type: 'FeatureCollection',
                features: [
                    {
                        type: 'Feature',
                        properties: {},
                        geometry: {
                            type: 'Point',
                            coordinates: coords
                        }
                    }
                ]
            };
            if (map.getLayer('end')) {
                map.getSource('end').setData(end);
            } else {
                map.addLayer({
                    id: 'end',
                    type: 'circle',
                    source: {
                        type: 'geojson',
                        data: {
                            type: 'FeatureCollection',
                            features: [{
                                    type: 'Feature',
                                    properties: {},
                                    geometry: {
                                        type: 'Point',
                                        coordinates: coords
                                    }
                                }]
                        }
                    },
                    paint: {
                        'circle-radius': 10,
                        'circle-color': '#444'
                    }
                });
            }
            getRouteWithInstructions(coords);
        });

    });

    //zoom controls
    let nav = new mapboxgl.NavigationControl();
    map.addControl(nav, "bottom-right");

    //zoom current location control
    let geolocate = new mapboxgl.GeolocateControl({
        accessToken: mapBoxAPIkey,
        positionOption: {
            enableHighAccuracy: true
        },
        trackUserLocation: true
    })
    map.addControl(geolocate, "bottom-right");

    //search bar
    let geocoder = new MapboxGeocoder({
        accessToken: mapBoxAPIkey,
        mapboxgl: mapboxgl,
        bbox: [-124.74291874132005, 25.101945677241105, -65.56472363838606, 48.98432947209429],
        proximity: {
            center
        }
    });
    map.addControl(geocoder, "top-right");
}