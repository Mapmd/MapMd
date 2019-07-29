package com.simpals.map.md.network;
import com.mapbox.mapboxsdk.module.http.HttpRequestUtil;

import java.util.Arrays;

import okhttp3.ConnectionSpec;
import okhttp3.OkHttpClient;

public class ApplicationIdentifier {
    public ApplicationIdentifier(String accessToken) {
        setToken(accessToken);
    }

    private void setToken(String accessToken) {
        OkHttpClient client = new OkHttpClient.Builder()
                /*.connectionSpecs(Arrays.asList(ConnectionSpec.COMPATIBLE_TLS))*/
                .addInterceptor(new BasicAuthInterceptor(accessToken, ""))
                .build();
        HttpRequestUtil.setOkHttpClient(client);
    }
}
