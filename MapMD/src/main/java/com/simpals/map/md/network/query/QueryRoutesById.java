package com.simpals.map.md.network.query;

import com.google.gson.JsonObject;
import com.simpals.map.md.mvp.Callback;
import com.simpals.map.md.mvp.CallbackResponse;
import com.simpals.map.md.mvp.GetFunction;
import com.simpals.map.md.mvp.routes.RouteGeoPresenterImpl;

public class QueryRoutesById implements CallbackResponse.RouteGeoView {
    private Callback.presenterRouteGeo presenter;
    private OnCallbackRouteGeoResult mListenerRoutes;

    public QueryRoutesById(OnCallbackRouteGeoResult listener) {
        this.mListenerRoutes = listener;
    }


    public QueryRoutesById() {

    }


    public void getRoute(String idRoute) {
        if (presenter == null) {
            presenter = new RouteGeoPresenterImpl(this, new GetFunction());
            presenter.requestRouteById(idRoute);
        } else {
            presenter.requestRouteById(idRoute);
        }
    }


    public void onCancelRequest() {
        if (presenter != null)
            presenter.onDestroy();
    }

    public void setOnRouteByIdListener(OnCallbackRouteGeoResult mListener) {
        this.mListenerRoutes = mListener;
    }

    @Override
    public void setDataRouteGeoView(JsonObject data, int statusCode) {
        if (mListenerRoutes != null)
            mListenerRoutes.onSuccess(data, statusCode);
    }

    @Override
    public void onResponseRouteGeoFailure(Throwable throwable) {
        if (mListenerRoutes != null)
            mListenerRoutes.onFailure(throwable);
    }


    public interface OnCallbackRouteGeoResult {
        void onSuccess(JsonObject result, int statusCode);

        void onFailure(Throwable throwable);
    }


}
