package com.simpals.map.md.exemple;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.simpals.map.md.MapMd;
import com.simpals.map.md.MapMdView;
import com.simpals.map.md.listener.OnMapMdReadyCallback;
import com.simpals.map.md.network.query.QueryCategory;
import com.simpals.map.md.network.query.QuerySearch;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements OnMapMdReadyCallback {
    private MapMdView mapView;
    // MapView mapView;
    private MapMd mapMd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MapMd.getInstanceMap(this, "2582e284-1087-421c-baaa-94020703c462");
        setContentView(R.layout.activity_main);
        mapView = (MapMdView) findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.initMap(this, this);
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

        /* new MainPresenterImpl(this, new GetNoticeIntractorImpl()).requestDataFromServer();*/
        // presenter.requestDataFromServer();
        // searchRequest();
        // searchLocation();
       // getAllCategory();
        getItemCategory("179");
    }

    private void searchLocation() {
        QuerySearch search = new QuerySearch(new QuerySearch.OnCallbackLocation() {
            @Override
            public void onSuccess(JsonObject result) {
                Log.e("response", result.toString());
            }

            @Override
            public void onFailure(Throwable throwable) {
                throwable.printStackTrace();
            }
        });
        Map m = new HashMap<>();
        m.put("id", "3157469661");
        search.getLocationRequest("city", m);
    }

    private void getAllCategory() {
        QueryCategory search = new QueryCategory(new QueryCategory.OnCallbackResult() {

            @Override
            public void onSuccess(JsonArray result, int statusCode) {
                Log.d("succes " + statusCode, result.toString());
            }

            @Override
            public void onFailure(Throwable throwable) {
                Log.e("succes ", throwable.toString());
            }
        });

        search.getAllCategory();
    }
    private void getItemCategory(String id) {
        QueryCategory search = new QueryCategory(new QueryCategory.OnCallbackResultItem() {

            @Override
            public void onSuccess(JsonObject result, int statusCode) {
                Log.d("succes " + statusCode, result.toString());
            }

            @Override
            public void onFailure(Throwable throwable) {
                Log.e("succes ", throwable.toString());
            }
        });

        search.getListCompanies(id);
    }

    private void searchRequest() {
        QuerySearch search = new QuerySearch(new QuerySearch.OnCallbackResult() {
            @Override
            public void onSuccess(JsonObject result) {
                Log.d("dacia", result.toString());
            }

            @Override
            public void onFailure(Throwable throwable) {

            }
        });

        search.sendRequest("daci");
        // search.onCancelRequest();
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

    /*private void getSearch(){
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(LoginViewModel.class);
        viewModel.loginResponse().observe(this, new Observer<ApiResponse>() {
            @Override
            public void onChanged(@Nullable ApiResponse apiResponse) {
                consumeResponse(apiResponse);
            }
        });

        viewModel.hitLoginApi(phoneNo.getText().toString(), password.getText().toString());
    }*/
}
