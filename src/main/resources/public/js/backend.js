"use strict";

//INIT MAPBOX
mapboxgl.accessToken = mapBoxAPIkey;

navigator.geolocation.getCurrentPosition(locationSuccess, locationError, { enableHighAccuracy: true })

function locationSuccess(position){
    setupMap([position.coords.longitude, position.coords.latitude]);
}

function locationError(error){
    console.log(error);
}

function setupMap(center) {
    let map = new mapboxgl.Map(
        {
            container: "map",
            style: 'mapbox://styles/mapbox/outdoors-v11',
            center: center,
            zoom: 8,
        });

    let nav = new mapboxgl.NavigationControl();
    map.addControl(nav, "bottom-right");

    let geolocate = new mapboxgl.GeolocateControl({
        positionOption: {
            enableHighAccuracy: true
        },
        trackUserLocation: true
    })
    map.addControl(geolocate, "bottom-right");

    // let directions = new MapboxDirections({
    //     accessToken: mapBoxAPIkey,
    //     profile: 'mapbox/walking'
    // });
    // map.addControl(directions, "top-left");

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