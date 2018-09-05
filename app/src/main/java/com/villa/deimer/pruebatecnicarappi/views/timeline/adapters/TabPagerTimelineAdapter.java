package com.villa.deimer.pruebatecnicarappi.views.timeline.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.villa.deimer.pruebatecnicarappi.views.timeline.fragments.TabMovies;
import com.villa.deimer.pruebatecnicarappi.views.timeline.fragments.TabSeries;
import java.util.List;

public class TabPagerTimelineAdapter extends FragmentPagerAdapter {

    private List<String> tab_titles;

    public TabPagerTimelineAdapter(FragmentManager fm, List<String> tabs) {
        super(fm);
        this.tab_titles = tabs;
    }

    @Override
    public int getCount() {
        return tab_titles.size();
    }

    @Override
    public Fragment getItem(int position) {
        Fragment f = null;
        String title = tab_titles.get(position);
        switch (title){
            case "Películas":
                f = TabMovies.newInstance();
                break;
            case "Series":
                f = TabSeries.newInstance();
                break;
        }
        return f;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tab_titles.get(position);
    }

}
