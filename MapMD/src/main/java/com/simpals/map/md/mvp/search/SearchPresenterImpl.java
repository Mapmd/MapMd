package com.simpals.map.md.mvp.search;

import com.simpals.map.md.mvp.Callback;

import org.json.JSONObject;

public class SearchPresenterImpl implements Callback.presenterSearch, GetMethod.OnFinishedListener {
    private CallbackResponse.SearchView searchView;
    private GetMethod getMethod;

    public SearchPresenterImpl(CallbackResponse.SearchView searchView, GetMethod onListener) {
        this.searchView = searchView;
        this.getMethod = onListener;
    }


    @Override
    public void onDestroy() {
        searchView = null;
    }

    @Override
    public void requestSearch(String query) {
        getMethod.getSearch(this, query);

    }

    @Override
    public void onFinished(JSONObject searchData) {
        if (searchView != null) {
            searchView.setDataSearchView(searchData);
        }

    }

    @Override
    public void onFailure(Throwable t) {
        if (searchView != null) {
            searchView.onResponseSearchFailure(t);
        }
    }
}
