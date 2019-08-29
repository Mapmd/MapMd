package com.simpals.map.md.listener;

import androidx.annotation.NonNull;

import com.mapbox.mapboxsdk.maps.MapboxMap;

public interface OnMapMdReadyCallback {

    void onMapReady(@NonNull MapboxMap mapMd);
}
