package com.simpals.map.md.listener;

import android.support.annotation.NonNull;

import com.mapbox.mapboxsdk.maps.MapboxMap;

public interface OnMapMdReadyCallback {

    void onMapReady(@NonNull MapboxMap mapMd);
}
