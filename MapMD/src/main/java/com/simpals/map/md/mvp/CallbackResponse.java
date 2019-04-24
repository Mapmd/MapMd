package com.simpals.map.md.mvp;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONObject;

public class CallbackResponse {
    public interface SearchView {
        void setDataSearchView(JsonObject data,int type);
        void onResponseSearchFailure(Throwable throwable,int type);
    }
    public interface CategoryView {
        void setDataCategoryView(JsonArray data,int code);
        void setDataItemPointView(JsonObject value,int statusCode);
        void onResponsePointFailure(Throwable throwable);
        void onResponseCategoryFailure(Throwable throwable);
    }
}
