package com.simpals.map.md.mvp.category;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.simpals.map.md.mvp.Callback;
import com.simpals.map.md.mvp.CallbackResponse;
import com.simpals.map.md.mvp.GetMethod;

public class CategoryPresenterImpl implements Callback.presenterCategory {
    private CallbackResponse.CategoryView categoryView;
    private GetMethod getMethod;

    public CategoryPresenterImpl(CallbackResponse.CategoryView categoryView, GetMethod onListener) {
        this.categoryView = categoryView;
        this.getMethod = onListener;
    }


    @Override
    public void onDestroy() {
        categoryView = null;
    }

    @Override
    public void requestAllCategory() {
        getMethod.getAllCategory(new GetMethod.OnCategoriesListener() {
            @Override
            public void onFinished(JsonArray searchData, int statusCode) {
                if (categoryView != null) {
                    categoryView.setDataCategoryView(searchData, statusCode);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                if (categoryView != null) {
                    categoryView.onResponseCategoryFailure(t);
                }
            }
        });

    }

    @Override
    public void requestPointItem(String categoryId) {
        getMethod.getPointItem(new GetMethod.OnPointItemListener() {

            @Override
            public void onFinished(JsonObject searchData, int statusCode) {
                if (categoryView != null) {
                    categoryView.setDataItemPointView(searchData, statusCode);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                if (categoryView != null) {
                    categoryView.onResponsePointFailure(t);
                }
            }
        }, categoryId);
    }

    public void registerView(CallbackResponse.CategoryView categoryView) {
        this.categoryView = categoryView;
    }
}
