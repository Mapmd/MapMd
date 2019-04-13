package com.simpals.map.md.mvp;

public class Callback {
    public interface presenterSearch {

        void onDestroy();

        void requestSearch(String query);
    }
}
