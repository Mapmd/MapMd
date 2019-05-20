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
import com.simpals.map.md.network.query.QueryDrive;
import com.simpals.map.md.network.query.QueryRoutes;
import com.simpals.map.md.network.query.QueryRoutesById;
import com.simpals.map.md.network.query.QuerySearch;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements OnMapMdReadyCallback {
    private MapMdView mapView;
    private MapMd mapMd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MapMd.getInstanceMap(this, "2582e284-1087-421c-baaa-94020703c462");
        setContentView(R.layout.activity_main);
        mapView = findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.initMap(this, this);

        /* new MainPresenterImpl(this, new GetNoticeIntractorImpl()).requestDataFromServer();*/
        // presenter.requestDataFromServer();
        // searchRequest();
        // searchLocation();
        //getAllCategory();
        getItemCategory("179");
        // getRoute();
        //getRouteById("52");
        //getDrive("28.847962,47.0441176;28.846471,46.993042");
       // getGeopoint(47.024775047203576,28.819843371108504);
    }

    private void getRoute() {
        QueryRoutes q = new QueryRoutes(new QueryRoutes.OnCallbackRoutesResult() {
            @Override
            public void onSuccess(JsonObject result, int statusCode) {
                Log.e("onSuccess", result.toString());
            }

            @Override
            public void onFailure(Throwable throwable) {
                Log.e("onFailure", throwable.toString());
            }
        });
        q.getRoute(null);
    }
    private void getGeopoint(double lat,double lon) {
        QueryRoutes q = new QueryRoutes(new QueryRoutes.OnCallbackNearResult() {
            @Override
            public void onSuccess(JsonObject result, int statusCode) {
                Log.e("onSuccess", result.toString());
            }

            @Override
            public void onFailure(Throwable throwable) {
                Log.e("onFailure", throwable.toString());
            }
        });
        q.getNear(lat,lon);
    }

    private void getRouteById(String idRoute) {
        QueryRoutesById q = new QueryRoutesById(new QueryRoutesById.OnCallbackRouteGeoResult() {
            @Override
            public void onSuccess(JsonObject result, int statusCode) {
                Log.e("onSuccess", result.toString());
            }

            @Override
            public void onFailure(Throwable throwable) {
                Log.e("onFailure", throwable.toString());
            }
        });

        q.getRoute(idRoute);
    }

    private void getDrive(String coordinates) {
        QueryDrive q = new QueryDrive(new QueryDrive.OnCallbackDriveResult() {
            @Override
            public void onSuccess(JsonObject result, int statusCode) {

                Log.e("onSuccess", result.toString());
            }

            @Override
            public void onFailure(Throwable throwable) {
                Log.e("onFailure", throwable.toString());
            }
        });
        q.getDrive("driving", coordinates);
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
        //get_street?number=2&id=30622244
        //get_object?id=144655
        //city?id=144655
        search.getLocationRequest("city", m);

    }

    private void getAllCategory() {
        QueryCategory queryCategory = new QueryCategory(new QueryCategory.OnCallbackResult() {

            @Override
            public void onSuccess(JsonArray result, int statusCode) {
                //Log.d("succes " + statusCode, result.toString());
            }

            @Override
            public void onFailure(Throwable throwable) {
                Log.e("error ", throwable.toString());
            }
        });

        queryCategory.getAllCategory();

       /* queryCategory.registerOnCategoryListener( new QueryCategory.OnCallbackResult(){

            @Override
            public void onSuccess(JsonArray result, int statusCode) {

            }

            @Override
            public void onFailure(Throwable throwable) {

            }
        });*/
    }

    private void getItemCategory(String id) {
        QueryCategory search = new QueryCategory(new QueryCategory.OnCallbackResultItem() {

            @Override
            public void onSuccess(JsonObject result, int statusCode) {
                Log.d("succes " + statusCode, result.toString());
            }

            @Override
            public void onFailure(Throwable throwable) {
                Log.e("error ", throwable.toString());
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
        mapView.setLogoTopLeft();
        // mapView.setStyleSatellite();

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
