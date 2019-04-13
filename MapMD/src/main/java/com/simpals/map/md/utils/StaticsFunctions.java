package com.simpals.map.md.utils;

import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.geometry.LatLngBounds;

public class StaticsFunctions {
    public static final LatLngBounds MOLDOVABOUNDS = new LatLngBounds.Builder()
            .include(new LatLng(48.63, 26.49))
            .include(new LatLng(45.2, 30.34))
            .build();
}
