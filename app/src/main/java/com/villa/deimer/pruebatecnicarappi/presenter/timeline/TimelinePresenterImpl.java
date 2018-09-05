package com.villa.deimer.pruebatecnicarappi.presenter.timeline;

import com.villa.deimer.pruebatecnicarappi.data.remote.RetrofitTimelineAdapter;
import com.villa.deimer.pruebatecnicarappi.model.entities.Item;
import com.villa.deimer.pruebatecnicarappi.views.timeline.TimelineInterface;

import java.util.List;

public class TimelinePresenterImpl implements TimelinePresenter {

    private TimelineInterface timelineInterface;

    public TimelinePresenterImpl(TimelineInterface timelineInterface) {
        this.timelineInterface = timelineInterface;
    }

    @Override
    public void getPopularMovies(String baseUrl, String apiKey, String language, int page) {
        RetrofitTimelineAdapter retrofitTimelineAdapter = new RetrofitTimelineAdapter(this, baseUrl);
        retrofitTimelineAdapter.getPopularMovies(apiKey, language, page);
    }

    @Override
    public void getTopRatedMovies(String baseUrl, String apiKey, String language, int page) {
        RetrofitTimelineAdapter retrofitTimelineAdapter = new RetrofitTimelineAdapter(this, baseUrl);
        retrofitTimelineAdapter.getTopRatedMovies(apiKey, language, page);
    }

    @Override
    public void getUpcomingMovies(String baseUrl, String apiKey, String language, int page) {
        RetrofitTimelineAdapter retrofitTimelineAdapter = new RetrofitTimelineAdapter(this, baseUrl);
        retrofitTimelineAdapter.getUpcomingMovies(apiKey, language, page);
    }

    @Override
    public void getPopularSeries(String baseUrl, String apiKey, String language, int page) {
        RetrofitTimelineAdapter retrofitTimelineAdapter = new RetrofitTimelineAdapter(this, baseUrl);
        retrofitTimelineAdapter.getPopularSeries(apiKey, language, page);
    }

    @Override
    public void getTopRatedSeries(String baseUrl, String apiKey, String language, int page) {
        RetrofitTimelineAdapter retrofitTimelineAdapter = new RetrofitTimelineAdapter(this, baseUrl);
        retrofitTimelineAdapter.getTopRatedSeries(apiKey, language, page);
    }

    @Override
    public void susccessDataList(List<Item> items, int page) {
        timelineInterface.getDataSuccess(items, page);
    }

    @Override
    public void getDataError(String error) {
        timelineInterface.getDataError(error);
    }

}
