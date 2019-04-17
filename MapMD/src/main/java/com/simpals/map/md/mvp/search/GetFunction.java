package com.simpals.map.md.mvp.search;

import android.support.annotation.NonNull;

import com.google.gson.JsonObject;
import com.simpals.map.md.mvp.RetrofitInstance;
import com.simpals.map.md.network.ApiMapMd;

import org.json.JSONObject;

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
    public void getSearch1(OnFinishedListener onFinishedListener) {

    }

    public void onCancelRequest() {
        if (call != null && call.isExecuted())
            call.cancel();
    }
}
