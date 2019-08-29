package com.simpals.map.md.network;

import androidx.annotation.NonNull;

import java.io.IOException;

import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class BasicAuthInterceptor implements Interceptor {
    private String credentials;
    //private String TAG;

    public BasicAuthInterceptor(String accessToken, String pwd) {
        this.credentials = Credentials.basic(accessToken, pwd);
    }

    @NonNull
    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request request = chain.request();
        Request authenticatedRequest = request.newBuilder()
                .header("Authorization", credentials)
                .header("Platform", "Android").build();
        return chain.proceed(authenticatedRequest);
    }
}
