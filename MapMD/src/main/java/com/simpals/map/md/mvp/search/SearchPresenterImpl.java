package com.simpals.map.md.mvp.search;

import com.google.gson.JsonObject;
import com.simpals.map.md.mvp.Callback;
import com.simpals.map.md.mvp.CallbackResponse;
import com.simpals.map.md.mvp.GetMethod;
import com.simpals.map.md.network.query.QuerySearch;

import java.util.Map;

public class SearchPresenterImpl implements Callback.presenterSearch {
    private CallbackResponse.SearchView searchView;
   // private CallbackResponse.LocationView locationView;
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
        getMethod.getSearch(new GetMethod.OnFinishedListener() {

            @Override
            public void onFinished(JsonObject searchData) {
                if (searchView != null) {
                    searchView.setDataSearchView(searchData, QuerySearch.TYPESEARCH);
                }

            }

            @Override
            public void onFailure(Throwable t) {
                if (searchView != null) {
                    searchView.onResponseSearchFailure(t, QuerySearch.TYPESEARCH);
                }
            }
        }, query);

    }

    @Override
    public void getLocation(String type, Map<String, String> param) {
        getMethod.getLocation(new GetMethod.OnLocationListener() {

            @Override
            public void onFinished(JsonObject searchData) {
                if (searchView != null)
                    searchView.setDataSearchView(searchData, QuerySearch.TYPELOCATION);
            }

            @Override
            public void onFailure(Throwable t) {
                if (searchView != null)
                    searchView.onResponseSearchFailure(t, QuerySearch.TYPELOCATION);
            }
        }, type, param);
    }

   /* public void registerView(CallbackResponse.LocationView locationView) {
        this.locationView = locationView;
    }*/

    public void registerView(CallbackResponse.SearchView searchView) {
        this.searchView = searchView;
    }
}
