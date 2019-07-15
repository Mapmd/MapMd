package com.simpals.map.md.network;
import com.mapbox.mapboxsdk.module.http.HttpRequestUtil;
import okhttp3.OkHttpClient;

public class ApplicationIdentifier {
    public ApplicationIdentifier(String accessToken) {
        setToken(accessToken);
    }

    private void setToken(String accessToken) {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new BasicAuthInterceptor(accessToken, ""))
                .build();
        HttpRequestUtil.setOkHttpClient(client);
    }
}
