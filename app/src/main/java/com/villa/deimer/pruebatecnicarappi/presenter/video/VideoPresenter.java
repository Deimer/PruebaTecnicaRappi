package com.villa.deimer.pruebatecnicarappi.presenter.video;

import com.villa.deimer.pruebatecnicarappi.model.entities.Video;
import java.util.List;

public interface VideoPresenter {

    void getVideoMovie(String baseUrl, int movieId, String apiKey, String language);
    void getVideoSerie(String baseUrl, int tvId, String apiKey, String language);

    void susccessDataVideo(List<Video> video);
    void getDataError(String error);

}
