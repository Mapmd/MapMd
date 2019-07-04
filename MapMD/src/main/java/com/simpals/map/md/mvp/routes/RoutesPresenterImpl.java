package com.simpals.map.md.mvp.routes;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.simpals.map.md.mvp.Callback;
import com.simpals.map.md.mvp.CallbackResponse;
import com.simpals.map.md.mvp.GetMethod;

public class RoutesPresenterImpl implements Callback.presenterRoutes {
    private CallbackResponse.RoutesView routesView;
    private GetMethod getMethod;

    public RoutesPresenterImpl(CallbackResponse.RoutesView routesView, GetMethod onListener) {
        this.routesView = routesView;
        this.getMethod = onListener;
    }


    @Override
    public void onDestroy() {
        routesView = null;
    }

    @Override
    public void requestRoutes(String cityId) {
        getMethod.getRoutes(new GetMethod.OnSuccessListener() {
            @Override
            public void onFinished(JsonObject searchData, int statusCode) {
                if (routesView != null) {
                    routesView.setDataRoutesView(searchData, statusCode);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                if (routesView != null) {
                    routesView.onResponseRouteFailure(t);
                }

            }
        }, cityId);
    }

    @Override
    public void requestNear(String lat, String lon) {
        getMethod.getNear(new GetMethod.OnSuccessListener() {
            @Override
            public void onFinished(JsonObject searchData, int statusCode) {
                if (routesView != null) {
                    routesView.setDataNearView(searchData, statusCode);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                if (routesView != null) {
                    if ((lat != null && lon != null) || !lat.isEmpty() && !lon.isEmpty()) {
                        double lat1 = Double.parseDouble(lat);
                        double lon1 = Double.parseDouble(lon);
                        LatLng latLng = new LatLng(lat1, lon1);
                        routesView.onResponseNearFailure(t, latLng);
                    }else routesView.onResponseNearFailure(t, null);
                }

            }
        }, lat, lon);
    }

    @Override
    public void requestNearMyLocation(String pointX, String pointY) {
        getMethod.getNearMyLocation(new GetMethod.OnSuccessArrayListener() {
            @Override
            public void onFinished(JsonArray searchData, int statusCode) {
                if (routesView != null) {
                    routesView.setDataNearViewMyLocation(searchData, statusCode);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                if (routesView != null) {
                    routesView.onResponseNearMyLocationFailure(t);
                }
            }
        }, pointX, pointY);
    }


    public void registerView(CallbackResponse.RoutesView routesView) {
        this.routesView = routesView;
    }
}
