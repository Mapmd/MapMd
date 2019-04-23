package com.simpals.map.md.mvp;

import java.util.Map;

public class Callback {
    public interface presenterSearch {
        void onDestroy();
        void requestSearch(String query);
        void getLocation(String type, Map<String,String> param);
    }
}
