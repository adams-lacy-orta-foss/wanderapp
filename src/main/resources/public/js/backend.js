"use strict";

// $(document).ready(()=>{
//     setTimeout(()=>{
//         $('.loading-screen').fadeOut()}, 3000);
// });

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
            zoom: 11,
        });

    map.on('load', () => {
        $('.loading-screen').fadeOut()
    });

    let nav = new mapboxgl.NavigationControl();
    map.addControl(nav, "bottom-right");

    let geolocate = new mapboxgl.GeolocateControl({
        accessToken: mapBoxAPIkey,
        positionOption: {
            enableHighAccuracy: true
        },
        trackUserLocation: true
    })
    map.addControl(geolocate, "bottom-right");

    //UNCOMMENT THIS FOR DIRECTION BOX TO DISPLAY IN UPPER LEFT HAND CORNER OF MAP
    let directions = new MapboxDirections({
        accessToken: mapBoxAPIkey,
        profile: 'mapbox/walking',
        bbox: [-124.74291874132005, 25.101945677241105, -65.56472363838606, 48.98432947209429],
        proximity: {
            center
        }
    });
    map.addControl(directions, "top-left");

    let geocoder = new MapboxGeocoder({
        accessToken: mapBoxAPIkey,
        mapboxgl: mapboxgl,
        bbox: [-124.74291874132005, 25.101945677241105, -65.56472363838606, 48.98432947209429],
        proximity: {
            center
        }
    });
    // map.addControl(geocoder, "top-right");
}

//KEVIN's MAPBOX CODE BELOW
//INIT MAPBOX
// mapboxgl.accessToken = mapBoxAPIkey;
// const geojson = {
//     type: 'FeatureCollection',
//     features: [
//         {
//             type: 'Feature',
//             geometry: {
//                 type: 'Point',
//                 coordinates: [-77.032, 38.913]
//             },
//             properties: {
//                 title: 'Mapbox',
//                 description: 'Washington, D.C.'
//             }
//         },
//         {
//             type: 'Feature',
//             geometry: {
//                 type: 'Point',
//                 coordinates: [-122.414, 37.776]
//             },
//             properties: {
//                 title: 'Mapbox',
//                 description: 'San Francisco, California'
//             }
//         }
//     ]
// };
//
// let map = new mapboxgl.Map(
//     {
//         container: "map",
//         style: 'mapbox://styles/mapbox/outdoors-v11',
//         center: [-98.4861, 29.4252],
//         zoom: 12,
//     });
//
//
//
// // add markers to map
// for (const feature of geojson.features) {
//     // create a HTML element for each feature
//     const el = document.createElement('div');
//     el.className = 'marker';
//
//     // make a marker for each feature and add to the map
//     new mapboxgl.Marker(el)
//         .setLngLat(feature.geometry.coordinates)
//         .setPopup(
//             new mapboxgl.Popup({offset: 25}) // add popups
//                 .setHTML(
//                     `<h3>${feature.properties.title}</h3><p>${feature.properties.description}</p>`
//                 )
//         )
//         .addTo(map);
// }
//
// document.getElementById('state-city-btn').addEventListener('click', function (e) {
//         e.preventDefault();
//         let streetInp = document.getElementById('street').value;
//         let cityInp = document.getElementById('city').value;
//         let stateInp = document.getElementById('state').value;
//         let searchInp = streetInp + ' ' + cityInp + ' ' + stateInp;
//
//         geocode(searchInp, mapBoxAPIkey).then(function (data) {
//             console.log(data);
//             map.flyTo({center: data, zoom: 13});
//             // let marker = new mapboxgl.Marker().setLngLat(data).addTo(map);
//         });
//     }
// );