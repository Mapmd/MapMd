package com.simpals.map.md.network.query;

import android.app.DownloadManager;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.simpals.map.md.mvp.Callback;
import com.simpals.map.md.mvp.CallbackResponse;
import com.simpals.map.md.mvp.GetFunction;
import com.simpals.map.md.mvp.category.CategoryPresenterImpl;
import com.simpals.map.md.mvp.routes.RoutesPresenterImpl;

public class QueryRoutes implements CallbackResponse.RoutesView {
    private Callback.presenterRoutes presenter;
    private OnCallbackRoutesResult mListenerRoutes;
    private OnCallbackNearResult mListenerNear;
    private OnCallbackNearLocationArray mListenerLocationArray;
    private static String CHISINAU = "129991407";

    public QueryRoutes(OnCallbackRoutesResult listener) {
        this.mListenerRoutes = listener;
    }

    public QueryRoutes(OnCallbackNearResult listener) {
        this.mListenerNear = listener;
    }

    public QueryRoutes(OnCallbackNearLocationArray listener) {
        this.mListenerLocationArray = listener;
    }

    public QueryRoutes() {

    }


    public void getRoute(String idCity) {
        if (idCity == null || idCity.equals(""))
            idCity = CHISINAU;
        if (presenter == null) {
            presenter = new RoutesPresenterImpl(this, new GetFunction());
            presenter.requestRoutes(idCity);
        } else {
            presenter.requestRoutes(idCity);
        }
    }

    public void getNear(double lat, double lon) {
        if (presenter == null) {
            presenter = new RoutesPresenterImpl(this, new GetFunction());
            presenter.requestNear(String.valueOf(lat), String.valueOf(lon));
        } else {
            presenter.requestNear(String.valueOf(lat), String.valueOf(lon));
        }
    }

    public void getNearMyLocation(String pointX, String pointY) {
        if (presenter == null) {
            presenter = new RoutesPresenterImpl(this, new GetFunction());
            presenter.requestNearMyLocation(pointX, pointY);
        } else {
            presenter.requestNearMyLocation(pointX, pointY);
        }
    }

    public void onCancelRequest() {
        if (presenter != null)
            presenter.onDestroy();
    }

    @Override
    public void setDataRoutesView(JsonObject data, int statusCode) {
        if (mListenerRoutes != null)
            mListenerRoutes.onSuccess(data, statusCode);
    }

    @Override
    public void setDataNearView(JsonObject value, int statusCode) {
        if (mListenerNear != null)
            mListenerNear.onSuccess(value, statusCode);
    }

    @Override
    public void setDataNearViewMyLocation(JsonArray data, int code) {
        if (mListenerLocationArray != null)
            mListenerLocationArray.onSuccess(data, code);
    }

    @Override
    public void onResponseRouteFailure(Throwable throwable) {
        if (mListenerRoutes != null)
            mListenerRoutes.onFailure(throwable);
    }

    @Override
    public void onResponseNearFailure(Throwable throwable,LatLng latLng) {
        if (mListenerNear != null)
            mListenerNear.onFailure(throwable,latLng);
    }

    @Override
    public void onResponseNearMyLocationFailure(Throwable throwable) {
        if (mListenerLocationArray != null)
            mListenerLocationArray.onFailure(throwable);
    }

    public void setOnNearListener(OnCallbackNearResult mListener) {
        this.mListenerNear = mListener;
    }

    public void setOnRoutesListener(OnCallbackRoutesResult mListener) {
        this.mListenerRoutes = mListener;
    }

    public void setOnNearLocationListener(OnCallbackNearLocationArray mListener) {
        this.mListenerLocationArray = mListener;
    }

    public interface OnCallbackRoutesResult {
        void onSuccess(JsonObject result, int statusCode);

        void onFailure(Throwable throwable);
    }

    public interface OnCallbackNearResult {
        void onSuccess(JsonObject result, int statusCode);
        void onFailure(Throwable throwable, LatLng latLng);
    }

    public interface OnCallbackNearLocationArray {
        void onSuccess(JsonArray result, int statusCode);

        void onFailure(Throwable throwable);
    }

}
