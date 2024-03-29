package com.simpals.map.md;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.util.AttributeSet;

import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.MapboxMapOptions;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.Style;
import com.simpals.map.md.listener.OnMapMdReadyCallback;
import com.simpals.map.md.utils.MapGravity;

import static com.mapbox.mapboxsdk.Mapbox.getApplicationContext;
import static com.simpals.map.md.utils.StaticsFunctions.MOLDOVABOUNDS;

import timber.log.Timber;

public class MapMdView extends MapView implements OnMapReadyCallback {
    //  private MapboxMap mMapboxMap = null;
    private OnMapMdReadyCallback mMapReadyCallback;
    private Context ctx;
    private MapboxMap mapMd;
    private int type = 0;
    public static int TYPE_SATELLITE = 1;
    public static int TYPE_DEFAULT = 0;

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

    public void initMap(Context ctx, OnMapMdReadyCallback mMapReadyCallback, int type) {
        this.ctx = ctx;
        this.type = type;
        this.mMapReadyCallback = mMapReadyCallback;
        getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull MapboxMap mapboxMap) {
        this.mapMd = mapboxMap;
        if (type == TYPE_DEFAULT) {
            setInitMapMd(mapboxMap);
        } else {
            setInitMapMdSatellite(mapboxMap);
        }
        if (mMapReadyCallback != null) mMapReadyCallback.onMapReady(mapboxMap);
    }

    private void setInitMapMd(MapboxMap mapboxMap) {
        mapboxMap.getUiSettings().setAttributionEnabled(false);
        mapboxMap.setStyle(new Style.Builder().fromUrl(getApplicationContext().getString(R.string.url_repo)), style -> {
            // addStyle(style);
        });
        mapboxMap.setLatLngBoundsForCameraTarget(MOLDOVABOUNDS);
    }

    private void setInitMapMdSatellite(MapboxMap mapboxMap) {
        mapboxMap.getUiSettings().setAttributionEnabled(false);
        mapboxMap.setStyle(new Style.Builder().fromUrl(getApplicationContext().getString(R.string.url_repo_satelite)), style -> {
            // addStyle(style);
        });
        mapboxMap.setLatLngBoundsForCameraTarget(MOLDOVABOUNDS);
    }

    public void setLogoTopLeft() {
        if (mapMd != null)
            setGravity(MapGravity.TOPLEFT.toGravity());
        else
            Timber.d("error init map");

    }

    public void setLogoTopRight() {
        if (mapMd != null)
            setGravity(MapGravity.TOPRIGHT.toGravity());
        else
            Timber.d("error init map");
    }

    public void setLogoBottomRight() {
        if (mapMd != null)
            setGravity(MapGravity.BOTTOMRIGHT.toGravity());
        else
            Timber.d("error init map");

    }

    public void setLogoBottomLeft() {
        if (mapMd != null)
            setGravity(MapGravity.BOTTOMLEFT.toGravity());
        else
            Timber.d("error init map");

    }

    public void setStyleSatellite(Style.OnStyleLoaded style){
        mapMd.setStyle(new Style.Builder().fromUrl(getApplicationContext().getString(R.string.url_repo_satelite)),style);
    }
    public void setStyleMapMd(Style.OnStyleLoaded style){
        mapMd.setStyle(new Style.Builder().fromUrl(getApplicationContext().getString(R.string.url_repo)),style);
    }

    private void setGravity(int gravity) {
        mapMd.getUiSettings().setLogoGravity(gravity);
    }

    public MapboxMap getMapMd() {
        return mapMd;
    }


}
