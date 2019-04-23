package com.simpals.map.md.network;


import com.google.gson.JsonObject;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

import static com.simpals.map.md.utils.Urls.POINTSTREET;
import static com.simpals.map.md.utils.Urls.SEARCH_STREET;

public interface ApiMapMd {
    @GET(SEARCH_STREET)
    Call<JsonObject> getStreet(@Query("q") String query);

    @GET(POINTSTREET)
    Call<JsonObject> getPointStreet(@Path("type") String stringType, @QueryMap Map<String, String> params);
}
