package com.simpals.map.md.mvp.routes;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
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
        getMethod.getRoutes(new GetMethod.OnSuccesListener() {
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
        getMethod.getNear(new GetMethod.OnSuccesListener() {
            @Override
            public void onFinished(JsonObject searchData, int statusCode) {
                if (routesView != null) {
                    routesView.setDataNearView(searchData, statusCode);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                if (routesView != null) {
                    routesView.onResponseNearFailure(t);
                }

            }
        }, lat, lon);
    }


    public void registerView(CallbackResponse.RoutesView routesView) {
        this.routesView = routesView;
    }
}
