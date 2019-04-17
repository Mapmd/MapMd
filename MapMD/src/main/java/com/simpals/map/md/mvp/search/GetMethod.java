package com.simpals.map.md.mvp.search;

import com.google.gson.JsonObject;

import org.json.JSONObject;

public interface GetMethod {
    interface OnFinishedListener {
        void onFinished(JsonObject searchData);

        void onFailure(Throwable t);
    }

    interface OnFinishedListener1 {
        void onFinished(JSONObject searchData);

        void onFailure(Throwable t);
    }

    void getSearch(OnFinishedListener onFinishedListener, String query);

    void getSearch1(OnFinishedListener onFinishedListener);
}
