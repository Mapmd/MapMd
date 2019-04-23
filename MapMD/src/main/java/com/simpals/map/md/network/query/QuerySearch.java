package com.simpals.map.md.network.query;

import com.google.gson.JsonObject;
import com.simpals.map.md.mvp.Callback;
import com.simpals.map.md.mvp.search.CallbackResponse;
import com.simpals.map.md.mvp.search.GetFunction;
import com.simpals.map.md.mvp.search.SearchPresenterImpl;

import org.json.JSONObject;

import java.util.Map;

public class QuerySearch implements CallbackResponse.SearchView {
    public static int TYPESEARCH = 1;
    public static int TYPELOCATION = 2;
    private Callback.presenterSearch presenter;
    private OnCallbackResult mListener;
    private OnCallbackLocation mPointListener;

    public QuerySearch(OnCallbackResult listener) {
        mListener = listener;
    }

    public QuerySearch(OnCallbackLocation listener) {
        this.mPointListener = listener;
    }

    @Override
    public void setDataSearchView(JsonObject data, int type) {
        if (mListener != null && TYPESEARCH == type)
            mListener.onSuccess(data);
        else if (mPointListener != null && TYPELOCATION == type)
            mPointListener.onSuccess(data);

    }


    @Override
    public void onResponseSearchFailure(Throwable throwable, int type) {
        if (mListener != null && TYPESEARCH == type)
            mListener.onFailure(throwable);
        else if (mPointListener != null && TYPELOCATION == type)
            mPointListener.onFailure(throwable);
    }

    public void sendRequest(String query) {
        if (presenter == null) {
            presenter = new SearchPresenterImpl(this, new GetFunction());
            presenter.requestSearch(query);
        } else {
            presenter.requestSearch(query);
        }
    }

    public void getLocationRequest(String type, Map<String, String> param) {
        if (presenter == null) {
            presenter = new SearchPresenterImpl(this, new GetFunction());
            presenter.getLocation(type, param);
        } else {
            presenter.getLocation(type, param);

        }
    }

    public void onCancelRequest() {
        if (presenter != null)
            presenter.onDestroy();
    }

    public void registerOnSearchListener(OnCallbackResult mListener) {
        this.mListener = mListener;
    }

    public void registerOnPointListener(OnCallbackLocation mListener) {
        this.mPointListener = mListener;
    }

    public interface OnCallbackResult {
        void onSuccess(JsonObject result);

        void onFailure(Throwable throwable);
    }

    public interface OnCallbackLocation {
        void onSuccess(JsonObject result);

        void onFailure(Throwable throwable);
    }

}
