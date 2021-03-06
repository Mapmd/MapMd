package com.simpals.map.md;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.mapbox.mapboxsdk.Mapbox;
import com.simpals.map.md.network.ApplicationIdentifier;

public class MapMd {

    public static void getInstanceMap(@NonNull Context context, @Nullable String accessToken) {
        Mapbox.getInstance(context, accessToken);
        new ApplicationIdentifier(accessToken);
    }
}
