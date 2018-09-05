package com.villa.deimer.pruebatecnicarappi.views.details;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.squareup.picasso.Picasso;
import com.villa.deimer.pruebatecnicarappi.R;
import com.villa.deimer.pruebatecnicarappi.model.entities.Detail;
import com.villa.deimer.pruebatecnicarappi.model.entities.Genre;
import com.villa.deimer.pruebatecnicarappi.presenter.detail.DetailPresenter;
import com.villa.deimer.pruebatecnicarappi.presenter.detail.DetailPresenterImpl;
import com.villa.deimer.pruebatecnicarappi.views.video.VideoActivity;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailActivity extends AppCompatActivity implements DetailInterface {

    private Context context;
    private DetailPresenter detailPresenter;
    private int itemId;
    private boolean isMovie;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.img_cover)
    ImageView imgCover;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;
    @BindView(R.id.scroll)
    NestedScrollView scroll;
    @BindView(R.id.lbl_title)
    TextView lblTitle;
    @BindView(R.id.lbl_description)
    TextView lblDescription;
    @BindView(R.id.lbl_date)
    TextView lblDate;
    @BindView(R.id.lbl_link)
    TextView lblLink;
    @BindView(R.id.lbl_seasons)
    TextView lblSeasons;
    @BindView(R.id.lbl_genres)
    TextView lblGenres;
    @BindView(R.id.rating_bar)
    RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        setupActivity();
    }

    private void setupActivity() {
        context = this;
        detailPresenter = new DetailPresenterImpl(this);
        getExtras();
        setupToolbar();
        getDetailsItem();
    }

    private void getExtras() {
        Bundle extras = getIntent().getExtras();
        assert extras != null;
        isMovie = extras.getBoolean("isMovie");
        itemId = extras.getInt("itemId");
        String title = extras.getString("title");
        lblTitle.setText(title);
    }

    public void setupToolbar() {
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
            toolbar.setContentInsetStartWithNavigation(0);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
    }

    private void getDetailsItem() {
        String baseUrl = getString(R.string.base_url);
        String apiKey = getString(R.string.api_key);
        String language = getString(R.string.language_es);
        if(isMovie) {
            detailPresenter.getDetailMovie(baseUrl, itemId, apiKey, language);
        } else {
            detailPresenter.getDetailSerie(baseUrl, itemId, apiKey, language);
        }
    }

    @Override
    public void getDataSuccess(Detail detail) {
        progressBar.setVisibility(View.GONE);
        setupNestedScrollView(detail);
    }

    private void setupNestedScrollView(final Detail detail) {
        setupDataDetailsView(detail);
        scroll.setVisibility(View.VISIBLE);
        YoYo.with(Techniques.FadeIn)
                .duration(700)
                .playOn(scroll);
    }

    @SuppressLint("SetTextI18n")
    private void setupDataDetailsView(Detail detail) {
        loadImageDetail(detail.getPoster_path());
        lblDescription.setText((detail.getOverview().equals("")) ? "No registra datos" : detail.getOverview());
        lblDate.setText((detail.getRelease_date() == null) ? detail.getFirst_air_date() : detail.getRelease_date());
        lblLink.setText((detail.getHomepage() == null) ? "No registra datos" : detail.getHomepage());
        lblLink.setTextColor(ContextCompat.getColor(context, R.color.colorPrimaryDark));
        lblGenres.setText(listGenres(detail.getGenres()));
        if(!isMovie) {
            lblSeasons.setVisibility(View.VISIBLE);
            lblSeasons.setText(detail.getSeasons().size() +" "+ getString(R.string.lbl_seasons));
        }
        float rating = detail.getPopularity() / 50;
        ratingBar.setRating(rating);
    }

    private String listGenres(List<Genre> genres) {
        if(!genres.isEmpty()) {
            StringBuilder stringGenres = new StringBuilder();
            for (int i = 0; i < genres.size(); i++) {
                stringGenres.append(genres.get(i).getName()).append(", ");
            }
            return stringGenres.toString().trim().substring(0, stringGenres.length() - 2);
        } else {
            return "No registra datos";
        }
    }

    private void loadImageDetail(String path) {
        String baseUrlImage = getString(R.string.base_url_image);
        Picasso.with(context)
                .load(baseUrlImage + path)
                .placeholder(R.drawable.background_placeholder)
                .error(R.drawable.background_placeholder)
                .fit()
                .centerCrop()
                .into(imgCover);
    }

    @Override
    public void getDataError(String error) {
        Snackbar.make(toolbar, error, Snackbar.LENGTH_LONG).show();
    }

    @OnClick(R.id.fab_video)
    public void openVideo() {
        Intent intent = new Intent(context, VideoActivity.class);
        intent.putExtra("itemId", itemId);
        intent.putExtra("isMovie", isMovie);
        startActivity(intent);
    }

}
