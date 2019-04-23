package com.simpals.map.md.mvp.search;

import com.google.gson.JsonObject;

import org.json.JSONObject;

public class CallbackResponse {
    public interface SearchView {
        void setDataSearchView(JsonObject data,int type);
        void onResponseSearchFailure(Throwable throwable,int type);
    }
    public interface LocationView {
        void setDataLocationView(JsonObject data);
        void onResponseLocationailure(Throwable throwable);
    }
}
