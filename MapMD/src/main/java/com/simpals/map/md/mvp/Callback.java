package com.simpals.map.md.mvp;

import java.util.Map;

public class Callback {
    public interface presenterSearch {
        void onDestroy();
        void requestSearch(String query);
        void getLocation(String type, Map<String,String> param);
    }

    public interface presenterCategory{
        void onDestroy();
        void requestAllCategory();
        void requestPointItem(String categoryId);
    }
    public interface presenterRoutes{
        void onDestroy();
        void requestRoutes(String cityId);
        void requestNear(String lat,String lon);
        void requestNearMyLocation(String PointX,String PointY);
    }

    public interface presenterRouteGeo{
        void onDestroy();
        void requestRouteById(String cityId);
    }

}
