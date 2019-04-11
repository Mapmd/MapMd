package com.simpals.map.md.exemple;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.Style;
import com.mapbox.mapboxsdk.style.sources.VectorSource;
import com.simpals.map.md.MapMd;
import com.simpals.map.md.MapMdView;
import com.simpals.map.md.listener.OnMapMdReadyCallback;

public class MainActivity extends AppCompatActivity  implements OnMapMdReadyCallback {
     private MapMdView mapView;
   // MapView mapView;
    private MapMd mapMd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MapMd.getInstanceMap(this, "f9302b9f-7e97-471b-85a3-2754b1466552");
        setContentView(R.layout.activity_main);
        mapView = (MapMdView) findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.initMap(this,this);
      /*  mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(@NonNull MapboxMap mapboxMap) {
                // mapboxMap.setStyle(new Style.Builder().fromUrl("asset://local_style_file.json")); https://i.simpalsmedia.com/tiles/styles/map/style.json
                mapboxMap.setStyle(new Style.Builder().fromUrl("http://192.168.1.15:8211/tiles/styles/map/style.json"), new Style.OnStyleLoaded() {
                    @Override
                    public void onStyleLoaded(@NonNull Style style) {

                        VectorSource vectorSource = new VectorSource(
                                "MapMd",
                                "https://i.simpalsmedia.com/tiles/styles/map/style.json");
                        style.addSource(vectorSource);


                    }
                });

            }
        });*/
    }

    @Override
    public void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    public void onMapReady(@NonNull MapboxMap mapMd) {

    }
}
