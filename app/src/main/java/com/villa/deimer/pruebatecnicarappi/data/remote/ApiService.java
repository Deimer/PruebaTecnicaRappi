package com.villa.deimer.pruebatecnicarappi.data.remote;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import com.google.gson.JsonObject;

public interface ApiService {

    //region Movies

    @GET("/3/movie/popular")
    Call<JsonObject> getPopularMovies(
            @Query("api_key")String apiKey,
            @Query("language")String language,
            @Query("page")int page
    );

    @GET("/3/movie/top_rated")
    Call<JsonObject> getTopRatedMovies(
            @Query("api_key")String apiKey,
            @Query("language")String language,
            @Query("page")int page
    );

    @GET("/3/movie/upcoming")
    Call<JsonObject> getUpcomingMovies(
            @Query("api_key")String apiKey,
            @Query("language")String language,
            @Query("page")int page
    );

    //endregion

    //region Series

    @GET("/3/tv/popular")
    Call<JsonObject> getPopularSeries(
            @Query("api_key")String apiKey,
            @Query("language")String language,
            @Query("page")int page
    );

    @GET("/3/tv/top_rated")
    Call<JsonObject> getTopRatedSeries(
            @Query("api_key")String apiKey,
            @Query("language")String language,
            @Query("page")int page
    );

    //endregion

    //region Details Movie

    @GET("/3/movie/{movie_id}")
    Call<JsonObject> getDetailMovie(
            @Path("movie_id")int movieId,
            @Query("api_key")String apiKey,
            @Query("language")String language
    );

    @GET("/3/movie/{movie_id}/videos")
    Call<JsonObject> getVideoMovie(
            @Path("movie_id")int movieId,
            @Query("api_key")String apiKey,
            @Query("language")String language
    );

    //endregion

    //region Details Serie

    @GET("/3/tv/{tv_id}")
    Call<JsonObject> getDetailSerie(
            @Path("tv_id")int tvId,
            @Query("api_key")String apiKey,
            @Query("language")String language
    );

    @GET("/3/tv/{tv_id}/videos")
    Call<JsonObject> getVideoSerie(
            @Path("tv_id")int tvId,
            @Query("api_key")String apiKey,
            @Query("language")String language
    );

    //endregion

}
