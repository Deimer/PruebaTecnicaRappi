package com.villa.deimer.pruebatecnicarappi.views.timeline.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayout;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayoutDirection;
import com.squareup.otto.Subscribe;
import com.villa.deimer.pruebatecnicarappi.R;
import com.villa.deimer.pruebatecnicarappi.events.MessageBusCategory;
import com.villa.deimer.pruebatecnicarappi.events.StationBus;
import com.villa.deimer.pruebatecnicarappi.model.entities.Item;
import com.villa.deimer.pruebatecnicarappi.presenter.timeline.TimelinePresenter;
import com.villa.deimer.pruebatecnicarappi.presenter.timeline.TimelinePresenterImpl;
import com.villa.deimer.pruebatecnicarappi.views.timeline.TimelineInterface;
import com.villa.deimer.pruebatecnicarappi.views.timeline.adapters.ItemRecyclerAdapter;
import com.villa.deimer.pruebatecnicarappi.views.timeline.dialogs.CreateDialog;

import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TabMovies extends Fragment implements TimelineInterface {

    //Components
    private Context context;
    private TimelinePresenter timelinePresenter;
    private int page;
    private int category;
    //Views
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.swipe_layout)
    SwipyRefreshLayout swipeLayout;

    public static TabMovies newInstance() {
        return new TabMovies();
    }

    public TabMovies(){}

    @Override
    public void onStart() {
        super.onStart();
        StationBus.getBus().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        StationBus.getBus().unregister(this);
    }

    @Subscribe
    public void recievedMessage(MessageBusCategory messageBusCategory){
        boolean active = messageBusCategory.isActive();
        if(active) {
            category = messageBusCategory.getOption();
            page = 1;
            getData();
        } else {
            String message = "Debe escoger una categoría valida.";
            Snackbar.make(recycler, message, Snackbar.LENGTH_LONG).show();
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frame_movies, container, false);
        ButterKnife.bind(this, view);
        setupFragment();
        return view;
    }

    private void setupFragment() {
        context = this.getContext();
        timelinePresenter = new TimelinePresenterImpl(this);
        page = 1;
        category = 1;
        getData();
        setupswipeLayout();
    }

    private void getData() {
        String baseUrl = getString(R.string.base_url);
        String apiKey = getString(R.string.api_key);
        String language = getString(R.string.language_es);
        if(category == 1) {
            timelinePresenter.getPopularMovies(baseUrl, apiKey, language, page);
        } else if(category == 2) {
            timelinePresenter.getTopRatedMovies(baseUrl, apiKey, language, page);
        } else if(category == 3) {
            timelinePresenter.getUpcomingMovies(baseUrl, apiKey, language, page);
        }
    }

    @Override
    public void getDataSuccess(List<Item> items, int mPage) {
        progressBar.setVisibility(View.GONE);
        if(swipeLayout.isRefreshing()){
            swipeLayout.setRefreshing(false);
        }
        if(!items.isEmpty()) {
            page = mPage + 1;
            setupRecycler(items);
        } else {
            String message = "Not data found.";
            Snackbar.make(recycler, message, Snackbar.LENGTH_LONG).show();
        }
    }

    @Override
    public void getDataError(String error) {
        Snackbar.make(recycler, error, Snackbar.LENGTH_LONG).show();
    }

    private void setupRecycler(List<Item> items) {
        String baseUrlImage = getString(R.string.base_url_image);
        ItemRecyclerAdapter adapter = new ItemRecyclerAdapter(context, items, baseUrlImage, true);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recycler.setLayoutManager(staggeredGridLayoutManager);
        recycler.setAdapter(adapter);
        recycler.setVisibility(View.VISIBLE);
    }

    private void setupswipeLayout() {
        swipeLayout.setOnRefreshListener(new SwipyRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh(SwipyRefreshLayoutDirection direction) {
                if(direction.equals(SwipyRefreshLayoutDirection.TOP)) {
                    page = 1;
                    getData();
                } else if(direction.equals(SwipyRefreshLayoutDirection.BOTTOM)) {
                    getData();
                }
            }
        });
    }

    @OnClick(R.id.fab)
    public void showDialogCategories() {
        CreateDialog dialog = new CreateDialog(context);
        List<String> categories = new ArrayList<>();
        categories.add("Categorías");
        categories.add("Populares");
        categories.add("Más Valorados");
        categories.add("Próximos");
        dialog.dialogSelectCategory(categories);
    }

}
