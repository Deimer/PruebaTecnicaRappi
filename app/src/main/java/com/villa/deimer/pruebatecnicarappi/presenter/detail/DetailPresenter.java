package com.villa.deimer.pruebatecnicarappi.presenter.detail;

import com.villa.deimer.pruebatecnicarappi.model.entities.Detail;

public interface DetailPresenter {

    void getDetailMovie(String baseUrl, int movieId, String apiKey, String language);
    void getDetailSerie(String baseUrl, int tvId, String apiKey, String language);

    void susccessDataDetail(Detail detail);
    void getDataError(String error);

}
