package com.simpals.map.md;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.MapboxMapOptions;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.Style;
import com.mapbox.mapboxsdk.style.sources.VectorSource;
import com.simpals.map.md.listener.OnMapMdReadyCallback;

import static com.mapbox.mapboxsdk.Mapbox.getApplicationContext;

public class MapMdView extends MapView implements OnMapReadyCallback {
    //  private MapboxMap mMapboxMap = null;
    private OnMapMdReadyCallback mMapReadyCallback;
    private Context ctx;

    public MapMdView(@NonNull Context context) {
        super(context);
    }

    public MapMdView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MapMdView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MapMdView(@NonNull Context context, @Nullable MapboxMapOptions options) {
        super(context, options);
    }

    public void initMap(Context ctx, OnMapMdReadyCallback mMapReadyCallback) {
        this.ctx = ctx;
        this.mMapReadyCallback = mMapReadyCallback;
        getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull MapboxMap mapboxMap) {
       // String url = ctx.getString(R.string.url_repo);
        mapboxMap.getUiSettings().setAttributionEnabled(false);
       // mapboxMap.getUiSettings().setLogoEnabled(false);

        mapboxMap.setStyle(new Style.Builder().fromUrl(getApplicationContext().getString(R.string.url_repo)), new Style.OnStyleLoaded() {
            @Override
            public void onStyleLoaded(@NonNull Style style) {

            }
        });
        if (mMapReadyCallback != null) mMapReadyCallback.onMapReady(mapboxMap);

    }


}
