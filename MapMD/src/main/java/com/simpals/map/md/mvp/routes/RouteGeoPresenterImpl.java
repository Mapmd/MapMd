package com.simpals.map.md.mvp.routes;

import com.google.gson.JsonObject;
import com.simpals.map.md.mvp.Callback;
import com.simpals.map.md.mvp.CallbackResponse;
import com.simpals.map.md.mvp.GetMethod;

public class RouteGeoPresenterImpl implements Callback.presenterRouteGeo {
    private CallbackResponse.RouteGeoView routeGeoView;
    private GetMethod getMethod;

    public RouteGeoPresenterImpl(CallbackResponse.RouteGeoView routeGeoView, GetMethod onListener) {
        this.routeGeoView = routeGeoView;
        this.getMethod = onListener;
    }


    @Override
    public void onDestroy() {
        routeGeoView = null;
    }

    @Override
    public void requestRouteById(String routeId) {
        getMethod.getRouteById(new GetMethod.OnSuccessListener() {
            @Override
            public void onFinished(JsonObject searchData, int statusCode) {
                if (routeGeoView != null) {
                    routeGeoView.setDataRouteGeoView(searchData, statusCode);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                if (routeGeoView != null) {
                    routeGeoView.onResponseRouteGeoFailure(t);
                }

            }
        }, routeId);
    }

    public void setRegisterView(CallbackResponse.RouteGeoView routesView) {
        this.routeGeoView = routesView;
    }
}
