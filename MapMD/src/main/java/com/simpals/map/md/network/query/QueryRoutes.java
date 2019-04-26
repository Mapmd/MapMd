package com.simpals.map.md.network.query;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.simpals.map.md.mvp.Callback;
import com.simpals.map.md.mvp.CallbackResponse;
import com.simpals.map.md.mvp.GetFunction;
import com.simpals.map.md.mvp.category.CategoryPresenterImpl;
import com.simpals.map.md.mvp.routes.RoutesPresenterImpl;

public class QueryRoutes implements CallbackResponse.RoutesView {
    private Callback.presenterRoutes presenter;
    private OnCallbackResult mListener;
    private OnCallbackResultArray mListenerArray;
    private static String CHISINAU = "129991407";

    public QueryRoutes(OnCallbackResult listener) {
        this.mListener = listener;
    }

    public QueryRoutes(OnCallbackResultArray listener) {
        this.mListenerArray = listener;
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
            presenter.requestNear(pointX, pointY);
        }
    }

    public void onCancelRequest() {
        if (presenter != null)
            presenter.onDestroy();
    }

    @Override
    public void setDataRoutesView(JsonObject data, int statusCode) {
        if (mListener != null)
            mListener.onSuccess(data, statusCode);
    }

    @Override
    public void setDataNearView(JsonObject value, int statusCode) {
        if (mListener != null)
            mListener.onSuccess(value, statusCode);
    }

    @Override
    public void setDataNearViewMyLocation(JsonArray data, int code) {
        if (mListenerArray != null)
            mListenerArray.onSuccess(data, code);
    }

    @Override
    public void onResponseRouteFailure(Throwable throwable) {
        if (mListener != null)
            mListener.onFailure(throwable);
    }

    @Override
    public void onResponseNearFailure(Throwable throwable) {
        if (mListener != null)
            mListener.onFailure(throwable);
    }

    @Override
    public void onResponseNearMyLocationFailure(Throwable throwable) {
        if (mListenerArray != null)
            mListenerArray.onFailure(throwable);
    }

    public void registerOnCategoryListener(OnCallbackResult mListener) {
        this.mListener = mListener;
    }

    public interface OnCallbackResult {
        void onSuccess(JsonObject result, int statusCode);

        void onFailure(Throwable throwable);
    }

    public interface OnCallbackResultArray {
        void onSuccess(JsonArray result, int statusCode);

        void onFailure(Throwable throwable);
    }

}
