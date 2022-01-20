'use strict'

$(document).ready(() => {
    let isMobile = false;
    if( $("#is-mobile-container").css('display') === 'none'){
        isMobile = true;
    }

    //THIS IS CONDITIONALLY RUN CODE DEPENDING ON WHETHER OR NOT THE USER IS ON A MOBILE DEVICE.
    if(isMobile){

    } else {

    }
});

//INIT MAPBOX
mapboxgl.accessToken = mapBoxAPIkey;
let map = new mapboxgl.Map(
    {
        container: "map",
        style: 'mapbox://styles/mapbox/outdoors-v11',
        center: [-98.4861, 29.4252],
        zoom: 12
    }
);