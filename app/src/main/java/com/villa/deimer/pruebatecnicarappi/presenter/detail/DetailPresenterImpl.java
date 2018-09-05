package com.villa.deimer.pruebatecnicarappi.presenter.detail;

import com.villa.deimer.pruebatecnicarappi.data.remote.RetrofitDetailAdapter;
import com.villa.deimer.pruebatecnicarappi.model.entities.Detail;
import com.villa.deimer.pruebatecnicarappi.views.details.DetailInterface;

public class DetailPresenterImpl implements DetailPresenter {

    private DetailInterface detailInterface;

    public DetailPresenterImpl(DetailInterface detailInterface) {
        this.detailInterface = detailInterface;
    }

    @Override
    public void getDetailMovie(String baseUrl, int movieId, String apiKey, String language) {
        RetrofitDetailAdapter retrofitDetailAdapter = new RetrofitDetailAdapter(baseUrl, this);
        retrofitDetailAdapter.getDetailMovie(movieId, apiKey, language);
    }

    @Override
    public void getDetailSerie(String baseUrl, int tvId, String apiKey, String language) {
        RetrofitDetailAdapter retrofitDetailAdapter = new RetrofitDetailAdapter(baseUrl, this);
        retrofitDetailAdapter.getDetailSerie(tvId, apiKey, language);
    }

    @Override
    public void susccessDataDetail(Detail detail) {
        detailInterface.getDataSuccess(detail);
    }

    @Override
    public void getDataError(String error) {
        detailInterface.getDataError(error);
    }
}
