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
const bounds = [
    [-106.320405, 25.404477, -90.664887, 33.257889]
];

const bound2 = [
    [-100.433890,28.344755],[-96.478812,30.310532]
];
let map = new mapboxgl.Map(
    {
        container: "map",
        style: 'mapbox://styles/mapbox/outdoors-v11',
        center: [-98.4861, 29.4252],
        zoom: 12,
        bbox: bound2
        });

document.getElementById('state-city-btn').addEventListener('click', function (e) {
        e.preventDefault();
        let streetInp = document.getElementById('street').value;
        let cityInp = document.getElementById('city').value;
        let stateInp = document.getElementById('state').value;
        let searchInp = streetInp + ' ' + cityInp + ' ' + stateInp;

        geocode(searchInp, mapBoxAPIkey).then(function (data) {
            console.log(data);
            map.flyTo({center: data, zoom: 13});
            let marker = new mapboxgl.Marker().setLngLat(data).addTo(map);
        });
    }
);