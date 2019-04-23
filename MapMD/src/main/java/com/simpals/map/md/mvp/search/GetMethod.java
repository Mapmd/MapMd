package com.simpals.map.md.mvp.search;

import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.util.Map;

public interface GetMethod {
    interface OnFinishedListener {
        void onFinished(JsonObject searchData);

        void onFailure(Throwable t);
    }

    interface OnLocationListener {
        void onFinished(JsonObject searchData);
        void onFailure(Throwable t);
    }

    void getSearch(OnFinishedListener onFinishedListener, String query);

    void getLocation(OnLocationListener onFinishedListener, String type, Map<String,String> param);
}
