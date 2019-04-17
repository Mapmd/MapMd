package com.simpals.map.md.network;


import com.google.gson.JsonObject;
import com.simpals.map.md.utils.Urls;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiMapMd {
    @GET(Urls.SEARCH_STREET)
    Call<JsonObject> getStreet(@Query("q") String query);
}
