package com.simpals.map.md.mvp;

import com.google.gson.JsonArray;
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

    interface OnCategoriesListener {
        void onFinished(JsonArray searchData, int statusCode);

        void onFailure(Throwable t);
    }

    interface OnPointItemListener {
        void onFinished(JsonObject searchData, int statusCode);

        void onFailure(Throwable t);
    }

    void getSearch(OnFinishedListener onFinishedListener, String query);

    void getPointItem(OnPointItemListener onFinishedListener, String CategoryId);

    void getAllCategory(OnCategoriesListener onCategoryListener);

    void getLocation(OnLocationListener onFinishedListener, String type, Map<String, String> param);
}
