'use strict'

$(document).ready(() => {
    let isMobile = false;
    if ($("#is-mobile-container").css('display') === 'none') {
        isMobile = true;
    }

    //THIS IS CONDITIONALLY RUN CODE DEPENDING ON WHETHER OR NOT THE USER IS ON A MOBILE DEVICE.
    if (isMobile) {

    } else {

    }
});

//INIT MAPBOX
mapboxgl.accessToken = mapBoxAPIkey;
const geojson = {
    type: 'FeatureCollection',
    features: [
        {
            type: 'Feature',
            geometry: {
                type: 'Point',
                coordinates: [-77.032, 38.913]
            },
            properties: {
                title: 'Mapbox',
                description: 'Washington, D.C.'
            }
        },
        {
            type: 'Feature',
            geometry: {
                type: 'Point',
                coordinates: [-122.414, 37.776]
            },
            properties: {
                title: 'Mapbox',
                description: 'San Francisco, California'
            }
        }
    ]
};

let map = new mapboxgl.Map(
    {
        container: "map",
        style: 'mapbox://styles/mapbox/outdoors-v11',
        center: [-98.4861, 29.4252],
        zoom: 12,
    });



// add markers to map
for (const feature of geojson.features) {
    // create a HTML element for each feature
    const el = document.createElement('div');
    el.className = 'marker';

    // make a marker for each feature and add to the map
    new mapboxgl.Marker(el)
        .setLngLat(feature.geometry.coordinates)
        .setPopup(
            new mapboxgl.Popup({offset: 25}) // add popups
                .setHTML(
                    `<h3>${feature.properties.title}</h3><p>${feature.properties.description}</p>`
                )
        )
        .addTo(map);
}

document.getElementById('state-city-btn').addEventListener('click', function (e) {
        e.preventDefault();
        let streetInp = document.getElementById('street').value;
        let cityInp = document.getElementById('city').value;
        let stateInp = document.getElementById('state').value;
        let searchInp = streetInp + ' ' + cityInp + ' ' + stateInp;

        geocode(searchInp, mapBoxAPIkey).then(function (data) {
            console.log(data);
            map.flyTo({center: data, zoom: 13});
            // let marker = new mapboxgl.Marker().setLngLat(data).addTo(map);
        });
    }
);


