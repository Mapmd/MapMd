package com.simpals.map.md.network.query;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.simpals.map.md.mvp.Callback;
import com.simpals.map.md.mvp.CallbackResponse;
import com.simpals.map.md.mvp.GetFunction;
import com.simpals.map.md.mvp.category.CategoryPresenterImpl;
import com.simpals.map.md.mvp.search.SearchPresenterImpl;

import java.util.Map;

public class QueryCategory implements CallbackResponse.CategoryView {
    /*public static int TYPESEARCH = 1;
    public static int TYPELOCATION = 2;*/
    private Callback.presenterCategory presenter;
    private OnCallbackResult mListener;
    private OnCallbackResultItem mListenerItem;

    public QueryCategory(OnCallbackResult listener) {
        this.mListener = listener;
    }

    public QueryCategory(OnCallbackResultItem listener) {
        this.mListenerItem = listener;
    }

    public void getAllCategory() {
        if (presenter == null) {
            presenter = new CategoryPresenterImpl(this, new GetFunction());
            presenter.requestAllCategory();
        } else {
            presenter.requestAllCategory();
        }
    }

    public void getListCompanies(String idCategories) {
        if (presenter == null) {
            presenter = new CategoryPresenterImpl(this, new GetFunction());
            presenter.requestPointItem(idCategories);
        } else {
            presenter.requestPointItem(idCategories);
        }
    }

    public void onCancelRequest() {
        if (presenter != null)
            presenter.onDestroy();
    }


    @Override
    public void setDataCategoryView(JsonArray data, int statusCode) {
        if (mListener != null)
            mListener.onSuccess(data, statusCode);
    }

    @Override
    public void setDataItemPointView(JsonObject value, int statusCode) {
        if (mListenerItem != null)
            mListenerItem.onSuccess(value, statusCode);
    }

    @Override
    public void onResponsePointFailure(Throwable throwable) {
        if (mListenerItem != null)
            mListenerItem.onFailure(throwable);
    }

    @Override
    public void onResponseCategoryFailure(Throwable throwable) {
        if (mListener != null)
            mListener.onFailure(throwable);
    }

    public void registerOnCategoryListener(OnCallbackResult mListener) {
        this.mListener = mListener;
    }

    public void registerOnCompaniesListener(OnCallbackResultItem mListener) {
        this.mListenerItem = mListener;
    }

    public interface OnCallbackResult {
        void onSuccess(JsonArray result, int statusCode);

        void onFailure(Throwable throwable);
    }

    public interface OnCallbackResultItem {
        void onSuccess(JsonObject result, int statusCode);

        void onFailure(Throwable throwable);
    }

}
