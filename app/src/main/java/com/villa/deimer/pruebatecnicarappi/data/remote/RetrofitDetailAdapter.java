package com.villa.deimer.pruebatecnicarappi.data.remote;

import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.villa.deimer.pruebatecnicarappi.model.entities.Detail;
import com.villa.deimer.pruebatecnicarappi.presenter.detail.DetailPresenter;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitDetailAdapter implements Callback<JsonObject> {

    private String baseUrl;
    private DetailPresenter detailPresenter;

    public RetrofitDetailAdapter(String baseUrl, DetailPresenter detailPresenter) {
        this.baseUrl = baseUrl;
        this.detailPresenter = detailPresenter;
    }

    private OkHttpClient setupOkHttpClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder().addInterceptor(interceptor).build();
    }

    public void getDetailMovie(int movieId, String apiKey, String language) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(setupOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService api = retrofit.create(ApiService.class);
        Call<JsonObject> call = api.getDetailMovie(movieId, apiKey, language);
        call.enqueue(this);
    }

    public void getDetailSerie(int tvId, String apiKey, String language) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(setupOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService api = retrofit.create(ApiService.class);
        Call<JsonObject> call = api.getDetailSerie(tvId, apiKey, language);
        call.enqueue(this);
    }

    public void getVideoMovie(int movieId, String apiKey, String language) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(setupOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService api = retrofit.create(ApiService.class);
        Call<JsonObject> call = api.getVideoMovie(movieId, apiKey, language);
        call.enqueue(this);
    }

    public void getVideoSerie(int tvId, String apiKey, String language) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(setupOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService api = retrofit.create(ApiService.class);
        Call<JsonObject> call = api.getVideoSerie(tvId, apiKey, language);
        call.enqueue(this);
    }

    @Override
    public void onResponse(@NonNull Call<JsonObject> call, @NonNull Response<JsonObject> response) {
        if(response.isSuccessful()) {
            JsonObject jsonObject = response.body();
            assert jsonObject != null;
            detailPresenter.susccessDataDetail(convertToObject(jsonObject));
        } else {
            detailPresenter.getDataError("code: " + response.code());
        }
    }

    @Override
    public void onFailure(@NonNull Call<JsonObject> call, @NonNull Throwable t) {
        detailPresenter.getDataError(t.getMessage());
    }

    private Detail convertToObject(JsonObject jsonObject) {
        JsonObject json = jsonObject.getAsJsonObject();
        return new Gson().fromJson(json, Detail.class);
    }

}
