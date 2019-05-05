package com.simpals.map.md.network.query;

import com.google.gson.JsonObject;
import com.simpals.map.md.mvp.Callback;
import com.simpals.map.md.mvp.CallbackResponse;
import com.simpals.map.md.mvp.GetFunction;
import com.simpals.map.md.mvp.routes.DrivePresenterImpl;
import com.simpals.map.md.mvp.routes.RouteGeoPresenterImpl;

public class QueryDrive implements CallbackResponse.DriveView {
    private Callback.presenterDrive presenter;
    private OnCallbackDriveResult mListenerRoutes;

    public QueryDrive(OnCallbackDriveResult listener) {
        this.mListenerRoutes = listener;
    }


    public QueryDrive() {

    }


    public void getDrive(String type,String coordinates) {
        if (presenter == null) {
            presenter = new DrivePresenterImpl(this, new GetFunction());
            presenter.requestDrive(type,coordinates);
        } else {
            presenter.requestDrive(type,coordinates);
        }
    }


    public void onCancelRequest() {
        if (presenter != null)
            presenter.onDestroy();
    }

    public void setOnRouteByIdListener(OnCallbackDriveResult mListener) {
        this.mListenerRoutes = mListener;
    }


    @Override
    public void setDataDriveView(JsonObject data, int statusCode) {
        if (mListenerRoutes != null)
            mListenerRoutes.onSuccess(data, statusCode);
    }

    @Override
    public void onResponseDriveFailure(Throwable throwable) {
        if (mListenerRoutes != null)
            mListenerRoutes.onFailure(throwable);
    }


    public interface OnCallbackDriveResult {
        void onSuccess(JsonObject result, int statusCode);

        void onFailure(Throwable throwable);
    }


}
