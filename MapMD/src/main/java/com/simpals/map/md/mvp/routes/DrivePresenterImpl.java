package com.simpals.map.md.mvp.routes;

import com.google.gson.JsonObject;
import com.simpals.map.md.mvp.Callback;
import com.simpals.map.md.mvp.CallbackResponse;
import com.simpals.map.md.mvp.GetMethod;

public class DrivePresenterImpl implements Callback.presenterDrive {
    private CallbackResponse.DriveView routeGeoView;
    private GetMethod getMethod;

    public DrivePresenterImpl(CallbackResponse.DriveView routeGeoView, GetMethod onListener) {
        this.routeGeoView = routeGeoView;
        this.getMethod = onListener;
    }


    @Override
    public void onDestroy() {
        routeGeoView = null;
    }

    @Override
    public void requestDrive(String type,String coordinates) {
        getMethod.getDrive(new GetMethod.OnSuccessListener() {
            @Override
            public void onFinished(JsonObject searchData, int statusCode) {
                if (routeGeoView != null) {
                    routeGeoView.setDataDriveView(searchData, statusCode);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                if (routeGeoView != null) {
                    routeGeoView.onResponseDriveFailure(t);
                }

            }
        },type, coordinates);
    }

    public void setRegisterView(CallbackResponse.DriveView routesView) {
        this.routeGeoView = routesView;
    }
}
