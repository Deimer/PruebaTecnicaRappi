package com.villa.deimer.pruebatecnicarappi.presenter.timeline;

import com.villa.deimer.pruebatecnicarappi.model.entities.Item;

import java.util.List;

public interface TimelinePresenter {

    void getPopularMovies(String baseUrl, String apiKey, String language, int page);
    void getTopRatedMovies(String baseUrl, String apiKey, String language, int page);
    void getUpcomingMovies(String baseUrl, String apiKey, String language, int page);

    void getPopularSeries(String baseUrl, String apiKey, String language, int page);
    void getTopRatedSeries(String baseUrl, String apiKey, String language, int page);

    void susccessDataList(List<Item> items, int page);
    void getDataError(String error);

}
