package com.simpals.map.md.mvp.search;

import com.google.gson.JsonObject;

import org.json.JSONObject;

public class CallbackResponse {
    public interface SearchView {
        void setDataSearchView(JsonObject data);
        void onResponseSearchFailure(Throwable throwable);
    }
}
