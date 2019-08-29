package com.simpals.map.md.network;
import com.mapbox.mapboxsdk.module.http.HttpRequestUtil;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import okhttp3.CipherSuite;
import okhttp3.ConnectionSpec;
import okhttp3.OkHttpClient;
import okhttp3.TlsVersion;
import okhttp3.logging.HttpLoggingInterceptor;

import static java.util.Collections.singletonList;

public class ApplicationIdentifier {
    public ApplicationIdentifier(String accessToken) {
        setToken(accessToken);
    }

    private void setToken(String accessToken) {
      /*  HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);*/

        OkHttpClient client = new OkHttpClient.Builder()
                /*.connectionSpecs(Arrays.asList(ConnectionSpec.COMPATIBLE_TLS))*/
                .addInterceptor(new BasicAuthInterceptor(accessToken, ""))
               // .addInterceptor(logging)
                .build();

        HttpRequestUtil.setOkHttpClient(client);
    }
}
