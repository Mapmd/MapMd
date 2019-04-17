package com.simpals.map.md.network.query;

import com.google.gson.JsonObject;
import com.simpals.map.md.mvp.Callback;
import com.simpals.map.md.mvp.search.CallbackResponse;
import com.simpals.map.md.mvp.search.GetFunction;
import com.simpals.map.md.mvp.search.SearchPresenterImpl;

import org.json.JSONObject;

public class QuerySearch implements CallbackResponse.SearchView {
    private Callback.presenterSearch presenter;
    private OnCallbackResult mListener;

    public QuerySearch(OnCallbackResult listener) {
        mListener = listener;
    }

    @Override
    public void setDataSearchView(JsonObject data) {
        if (mListener != null)
            mListener.onSuccess(data);

    }

    @Override
    public void onResponseSearchFailure(Throwable throwable) {
        if (mListener != null)
            mListener.onFailure(throwable);
    }

    public void sendRequest(String query) {
        if (presenter == null) {
            presenter = new SearchPresenterImpl(this, new GetFunction());
            presenter.requestSearch(query);
        } else {
            presenter.requestSearch(query);
        }
    }

    public void onCancelRequest() {
        if (presenter != null)
            presenter.onDestroy();
    }

    public void registerOnSearchListener(OnCallbackResult mListener) {
        this.mListener = mListener;
    }

    public interface OnCallbackResult {
        void onSuccess(JsonObject result);

        void onFailure(Throwable throwable);
    }

}
