package com.villa.deimer.pruebatecnicarappi.data.remote;

import android.support.annotation.NonNull;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.converter.gson.GsonConverterFactory;
import com.villa.deimer.pruebatecnicarappi.model.entities.Item;
import com.villa.deimer.pruebatecnicarappi.presenter.timeline.TimelinePresenter;

public class RetrofitTimelineAdapter implements Callback<JsonObject> {

    private String baseUrl;
    private TimelinePresenter timelinePresenter;

    public RetrofitTimelineAdapter(TimelinePresenter timelinePresenter, String baseUrl) {
        this.timelinePresenter = timelinePresenter;
        this.baseUrl = baseUrl;
    }

    private OkHttpClient setupOkHttpClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder().addInterceptor(interceptor).build();
    }

    public void getPopularMovies(String apiKey, String language, int page) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(setupOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService api = retrofit.create(ApiService.class);
        Call<JsonObject> call = api.getPopularMovies(apiKey, language, page);
        call.enqueue(this);
    }

    public void getTopRatedMovies(String apiKey, String language, int page) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(setupOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService api = retrofit.create(ApiService.class);
        Call<JsonObject> call = api.getTopRatedMovies(apiKey, language, page);
        call.enqueue(this);
    }

    public void getUpcomingMovies(String apiKey, String language, int page) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(setupOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService api = retrofit.create(ApiService.class);
        Call<JsonObject> call = api.getUpcomingMovies(apiKey, language, page);
        call.enqueue(this);
    }

    public void getPopularSeries(String apiKey, String language, int page) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(setupOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService api = retrofit.create(ApiService.class);
        Call<JsonObject> call = api.getPopularSeries(apiKey, language, page);
        call.enqueue(this);
    }

    public void getTopRatedSeries(String apiKey, String language, int page) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(setupOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService api = retrofit.create(ApiService.class);
        Call<JsonObject> call = api.getTopRatedSeries(apiKey, language, page);
        call.enqueue(this);
    }

    @Override
    public void onResponse(@NonNull Call<JsonObject> call, @NonNull Response<JsonObject> response) {
        if(response.isSuccessful()) {
            JsonObject jsonObject = response.body();
            assert jsonObject != null;
            List<Item> items = convertToList(jsonObject);
            int page = jsonObject.get("page").getAsInt();
            timelinePresenter.susccessDataList(items, page);
        } else {
            timelinePresenter.getDataError("code: " + response.code());
        }
    }

    @Override
    public void onFailure(@NonNull Call<JsonObject> call, @NonNull Throwable t) {
        timelinePresenter.getDataError(t.getMessage());
    }

    private List<Item> convertToList(JsonObject jsonObject) {
        List<Item> items = new ArrayList<>();
        JsonArray results = jsonObject.getAsJsonArray("results");
        for (int i = 0; i < results.size(); i++) {
            JsonObject json = results.get(i).getAsJsonObject();
            Item item = new Gson().fromJson(json, Item.class);
            items.add(item);
        }
        return items;
    }

}
