'use strict'
//INSERT THE MAPBOX API KEY
mapboxgl.accessToken = mapBoxAPIkey;
//START BY PUTTING BASIC MAP ON SCREEN
var map = new mapboxgl.Map(
    {
        container: "map",
        style: 'mapbox://styles/mapbox/outdoors-v11',
        center: [-98.4861, 29.4252],
        zoom: 12

    }
)