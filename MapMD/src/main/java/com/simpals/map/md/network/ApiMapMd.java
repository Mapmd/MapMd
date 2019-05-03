package com.simpals.map.md.network;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

import static com.simpals.map.md.utils.Urls.ALLCATEGORIES;
import static com.simpals.map.md.utils.Urls.GET_NEAR;
import static com.simpals.map.md.utils.Urls.GET_POINTS_FOR_CATEGORY;
import static com.simpals.map.md.utils.Urls.GET_ROUTES;
import static com.simpals.map.md.utils.Urls.GET_ROUTE_BY_ID;
import static com.simpals.map.md.utils.Urls.POINTSTREET;
import static com.simpals.map.md.utils.Urls.SEARCH_STREET;

public interface ApiMapMd {
    @GET(SEARCH_STREET)
    Call<JsonObject> getStreet(@Query("q") String query);

    @GET(POINTSTREET)
    Call<JsonObject> getPointStreet(@Path("type") String stringType, @QueryMap Map<String, String> params);

    @GET(ALLCATEGORIES)
    Call<JsonArray> getCategories();

    @GET(GET_POINTS_FOR_CATEGORY)
    Call<JsonObject> getPoint(@Query("parent_id") String parentId);

  /*  @GET("ru/map/webmap/route")
    Call<RequestCoordinate> getPointRoute(@Query("rid") String idRout);*/

    @GET(GET_ROUTES)
    Call<JsonObject> getRoute(@Query("city_id") String cityId);

    @GET(GET_NEAR)
    Call<JsonObject> getNear(@Query("lat") String lat, @Query("lon") String lon);

    @GET("ru/map/webmap/near_routes")
    Call<JsonArray> getRouteMyLocation(@Query("x") String x, @Query("y") String y); //x=47.0229,28.8353,y=47.0229,28.8353

    @GET(GET_ROUTE_BY_ID)
    Call<JsonObject> getRouteById(@Query("rid") String idRout);

}
