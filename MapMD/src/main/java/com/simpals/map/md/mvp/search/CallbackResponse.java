package com.simpals.map.md.mvp.search;

import org.json.JSONObject;

public class CallbackResponse {
    public interface SearchView {
        void setDataSearchView(JSONObject data);
        void onResponseSearchFailure(Throwable throwable);
    }
}
