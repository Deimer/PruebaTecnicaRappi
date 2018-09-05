package com.villa.deimer.pruebatecnicarappi.data.remote;

import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.villa.deimer.pruebatecnicarappi.model.entities.Video;
import com.villa.deimer.pruebatecnicarappi.presenter.video.VideoPresenter;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitVideoAdapter implements Callback<JsonObject> {

    private String baseUrl;
    private VideoPresenter videoPresenter;

    public RetrofitVideoAdapter(String baseUrl, VideoPresenter videoPresenter) {
        this.baseUrl = baseUrl;
        this.videoPresenter = videoPresenter;
    }

    private OkHttpClient setupOkHttpClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder().addInterceptor(interceptor).build();
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
            videoPresenter.susccessDataVideo(convertToObject(jsonObject));
        } else {
            videoPresenter.getDataError("code: " + response.code());
        }
    }

    @Override
    public void onFailure(@NonNull Call<JsonObject> call, @NonNull Throwable t) {
        videoPresenter.getDataError(t.getMessage());
    }

    private List<Video> convertToObject(JsonObject jsonObject) {
        List<Video> videos = new ArrayList<>();
        JsonArray array = jsonObject.getAsJsonArray("results");
        if(array.size() > 0) {
            JsonObject json = array.get(0).getAsJsonObject();
            Video video = new Gson().fromJson(json, Video.class);
            videos.add(video);
        }
        return videos;
    }

}
