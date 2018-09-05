package com.villa.deimer.pruebatecnicarappi.presenter.video;

import com.villa.deimer.pruebatecnicarappi.data.remote.RetrofitVideoAdapter;
import com.villa.deimer.pruebatecnicarappi.model.entities.Video;
import com.villa.deimer.pruebatecnicarappi.views.video.VideoInterface;

import java.util.List;

public class VideoPresenterImpl implements VideoPresenter {

    VideoInterface videoInterface;

    public VideoPresenterImpl(VideoInterface videoInterface) {
        this.videoInterface = videoInterface;
    }

    @Override
    public void getVideoMovie(String baseUrl, int movieId, String apiKey, String language) {
        RetrofitVideoAdapter videoAdapter = new RetrofitVideoAdapter(baseUrl, this);
        videoAdapter.getVideoMovie(movieId, apiKey, language);
    }

    @Override
    public void getVideoSerie(String baseUrl, int tvId, String apiKey, String language) {
        RetrofitVideoAdapter videoAdapter = new RetrofitVideoAdapter(baseUrl, this);
        videoAdapter.getVideoSerie(tvId, apiKey, language);
    }

    @Override
    public void susccessDataVideo(List<Video> videos) {
        videoInterface.getDataSuccess(videos);
    }

    @Override
    public void getDataError(String error) {
        videoInterface.getDataError(error);
    }

}
