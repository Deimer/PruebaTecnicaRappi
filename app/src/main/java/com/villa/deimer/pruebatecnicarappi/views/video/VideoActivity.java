package com.villa.deimer.pruebatecnicarappi.views.video;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.os.Bundle;
import android.widget.Toast;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.villa.deimer.pruebatecnicarappi.R;
import com.villa.deimer.pruebatecnicarappi.model.entities.Video;
import com.villa.deimer.pruebatecnicarappi.presenter.video.VideoPresenter;
import com.villa.deimer.pruebatecnicarappi.presenter.video.VideoPresenterImpl;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

public class VideoActivity extends YouTubeBaseActivity implements VideoInterface {

    private Context context;
    private VideoPresenter videoPresenter;
    private YouTubePlayer.OnInitializedListener onInitializedListener;
    private boolean isMovie;
    private int itemId;

    @BindView(R.id.frame_video)
    YouTubePlayerView frameVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        ButterKnife.bind(this);
        setupActivity();
    }

    private void setupActivity() {
        context = this;
        videoPresenter = new VideoPresenterImpl(this);
        getExtras();
        getData();
    }

    private void getExtras() {
        Bundle extras = getIntent().getExtras();
        assert extras != null;
        isMovie = extras.getBoolean("isMovie");
        itemId = extras.getInt("itemId");
    }

    private void getData() {
        String baseUrl = getString(R.string.base_url);
        String apiKey = getString(R.string.api_key);
        String language = getString(R.string.language_es);
        if(isMovie) {
            videoPresenter.getVideoMovie(baseUrl, itemId, apiKey, language);
        } else {
            videoPresenter.getVideoSerie(baseUrl, itemId, apiKey, language);
        }
    }

    @Override
    public void getDataSuccess(List<Video> videos) {
        if(videos.isEmpty()) {
            Toast.makeText(context, "Este item no posee un video.", Toast.LENGTH_LONG).show();
            finish();
        } else {
            getkeyVideos(videos);
        }
    }

    private void getkeyVideos(List<Video> videos) {
        List<String> keyVideos = new ArrayList<>();
        for (int i = 0; i < videos.size(); i++) {
            Video video = videos.get(i);
            if(video.getSite().equalsIgnoreCase("YouTube")) {
                keyVideos.add(video.getKey());
            }
        }
        setupConfigVideo(keyVideos);
    }

    private void setupConfigVideo(List<String> keyVideos) {
        setupYouTubePlayerView(keyVideos);
        frameVideo.initialize(getString(R.string.key_youtube), onInitializedListener);
    }

    private void setupYouTubePlayerView(final List<String> keyVideos) {
        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideos(keyVideos);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Snackbar.make(frameVideo, "Error al coargar los videos de youtube.", Snackbar.LENGTH_LONG).show();
            }
        };
    }

    @Override
    public void getDataError(String error) {
        Snackbar.make(frameVideo, error, Snackbar.LENGTH_LONG).show();
    }
}
