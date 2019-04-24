package com.simpals.map.md.mvp;

import android.support.annotation.NonNull;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.simpals.map.md.mvp.GetMethod;
import com.simpals.map.md.mvp.RetrofitInstance;
import com.simpals.map.md.network.ApiMapMd;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetFunction implements GetMethod {
    private Call<JsonObject> call;

    @Override
    public void getSearch(final OnFinishedListener onFinishedListener, String query) {
        ApiMapMd service = RetrofitInstance.getRetrofitInstance().create(ApiMapMd.class);
        call = service.getStreet(query);
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(@NonNull Call<JsonObject> call, @NonNull Response<JsonObject> response) {
                onFinishedListener.onFinished(response.body());

            }

            @Override
            public void onFailure(@NonNull Call<JsonObject> call, @NonNull Throwable t) {
                onFinishedListener.onFailure(t);
            }
        });
    }

    @Override
    public void getPointItem(OnPointItemListener onFinishedListener, String CategoryId) {
        ApiMapMd service = RetrofitInstance.getRetrofitInstance().create(ApiMapMd.class);
        Call<JsonObject> call = service.getPoint(String.valueOf(CategoryId));
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(@NonNull Call<JsonObject> call, @NonNull Response<JsonObject> response) {
                if (response.code() == 200 && onFinishedListener != null) {
                    onFinishedListener.onFinished(response.body(), response.code());
                } else if (onFinishedListener != null) {
                    onFinishedListener.onFinished(response.body(), response.code());
                }
            }

            @Override
            public void onFailure(@NonNull Call<JsonObject> call, @NonNull Throwable t) {

            }
        });
    }

    @Override
    public void getAllCategory(OnCategoriesListener onCategoriesListener) {
        ApiMapMd service = RetrofitInstance.getRetrofitInstance().create(ApiMapMd.class);
        Call<JsonArray> call = service.getCategories();
        call.enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(@NonNull Call<JsonArray> call, @NonNull Response<JsonArray> response) {
                if (response.code() == 200 && onCategoriesListener != null) {
                    onCategoriesListener.onFinished(response.body(), response.code());
                } else if (onCategoriesListener != null) {
                    onCategoriesListener.onFinished(response.body(), response.code());
                }

            }

            @Override
            public void onFailure(@NonNull Call<JsonArray> call, @NonNull Throwable t) {
                if (onCategoriesListener != null)
                    onCategoriesListener.onFailure(t);
            }
        });
    }

    @Override
    public void getLocation(OnLocationListener onLocationListener, String type, Map<String, String> param) {
        ApiMapMd service = RetrofitInstance.getRetrofitInstance().create(ApiMapMd.class);
        call = service.getPointStreet(type, param);
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(@NonNull Call<JsonObject> call, @NonNull Response<JsonObject> response) {
                if (onLocationListener != null)
                    onLocationListener.onFinished(response.body());

            }

            @Override
            public void onFailure(@NonNull Call<JsonObject> call, @NonNull Throwable t) {
                if (onLocationListener != null)
                    onLocationListener.onFailure(t);
            }
        });
    }

    public void onCancelRequest() {
        if (call != null && call.isExecuted())
            call.cancel();
    }
}
