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

    public interface RoutesView {
        void setDataRoutesView(JsonObject data,int statusCode);
        void setDataNearView(JsonObject value,int statusCode);
        void setDataNearViewMyLocation(JsonArray data,int code);
        void onResponseRouteFailure(Throwable throwable);
        void onResponseNearFailure(Throwable throwable);
        void onResponseNearMyLocationFailure(Throwable throwable);
    }
}
