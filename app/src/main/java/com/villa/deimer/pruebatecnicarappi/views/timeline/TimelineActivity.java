package com.villa.deimer.pruebatecnicarappi.views.timeline;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import com.villa.deimer.pruebatecnicarappi.R;
import com.villa.deimer.pruebatecnicarappi.views.timeline.adapters.TabPagerTimelineAdapter;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

public class TimelineActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.lbl_title_activity)
    TextView lblTitle;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);
        ButterKnife.bind(this);
        setupActivity();
    }

    private void setupActivity() {
        setupToolbar();
        setupViewPager();
    }

    public void setupToolbar() {
        setSupportActionBar(toolbar);
        Typeface bebas_bold = Typeface.createFromAsset(getAssets(), "fonts/indiana.ttf");
        lblTitle.setTypeface(bebas_bold);
    }

    public void setupViewPager() {
        List<String> tab_titles = new ArrayList<>();
        tab_titles.add("Películas");
        tab_titles.add("Series");
        viewPager.setAdapter(new TabPagerTimelineAdapter(
                getSupportFragmentManager(),
                tab_titles
        ));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}
            @Override
            public void onPageSelected(int position) { }
            @Override
            public void onPageScrollStateChanged(int state) {}
        });
        setupTabLayout();
    }

    public void setupTabLayout() {
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setCurrentItem(0);
    }

}
