package com.simpals.map.md.mvp;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.Map;

public interface GetMethod {
    interface OnFinishedListener {
        void onFinished(JsonObject searchData);

        void onFailure(Throwable t);
    }
    interface OnSuccessListener {
        void onFinished(JsonObject searchData, int statusCode);
        void onFailure(Throwable t);
    }
    interface OnSuccessArrayListener {
        void onFinished(JsonArray searchData, int statusCode);
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

    void getRoutes(OnSuccessListener onRouteListener, String idCities);

    void getNear(OnSuccessListener onNearListener, String lat, String lon);
    void getNearMyLocation(OnSuccessArrayListener onSuccessArrayListener, String PointX, String PointY);

    void getPointItem(OnPointItemListener onFinishedListener, String CategoryId);

    void getAllCategory(OnCategoriesListener onCategoryListener);

    void getLocation(OnLocationListener onFinishedListener, String type, Map<String, String> param);
}
