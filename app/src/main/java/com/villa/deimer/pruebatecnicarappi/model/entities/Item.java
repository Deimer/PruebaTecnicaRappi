package com.villa.deimer.pruebatecnicarappi.model.entities;

import java.util.Arrays;

public class Item {

    private int id;
    private float vote_count;
    private boolean video;
    private float vote_average;
    private String title;
    private float popularity;
    private String poster_path;
    private String original_language;
    private String original_title;
    private String name;
    private String original_name;
    private int[] genre_ids;
    private String backdrop_path;
    private boolean adult;
    private String overview;
    private String release_date;
    private String first_air_date;

    public Item() {}
    public Item(int id, float vote_count, boolean video, float vote_average, String title,
                float popularity, String poster_path, String original_language, String original_title,
                String name, String original_name, int[] genre_ids, String backdrop_path, boolean adult,
                String overview, String release_date, String first_air_date) {
        this.id = id;
        this.vote_count = vote_count;
        this.video = video;
        this.vote_average = vote_average;
        this.title = title;
        this.popularity = popularity;
        this.poster_path = poster_path;
        this.original_language = original_language;
        this.original_title = original_title;
        this.name = name;
        this.original_name = original_name;
        this.genre_ids = genre_ids;
        this.backdrop_path = backdrop_path;
        this.adult = adult;
        this.overview = overview;
        this.release_date = release_date;
        this.first_air_date = first_air_date;
    }

    //region Setters
    public int getId() {
        return id;
    }
    public float getVote_count() {
        return vote_count;
    }
    public boolean isVideo() {
        return video;
    }
    public float getVote_average() {
        return vote_average;
    }
    public String getTitle() {
        return title;
    }
    public float getPopularity() {
        return popularity;
    }
    public String getPoster_path() {
        return poster_path;
    }
    public String getOriginal_language() {
        return original_language;
    }
    public String getOriginal_title() {
        return original_title;
    }
    public String getName() {
        return name;
    }
    public String getOriginal_name() {
        return original_name;
    }
    public int[] getGenre_ids() {
        return genre_ids;
    }
    public String getBackdrop_path() {
        return backdrop_path;
    }
    public boolean isAdult() {
        return adult;
    }
    public String getOverview() {
        return overview;
    }
    public String getRelease_date() {
        return release_date;
    }
    public String getFirst_air_date() {
        return first_air_date;
    }
    //endregion

    //region Setters
    public void setId(int id) {
        this.id = id;
    }
    public void setVote_count(float vote_count) {
        this.vote_count = vote_count;
    }
    public void setVideo(boolean video) {
        this.video = video;
    }
    public void setVote_average(float vote_average) {
        this.vote_average = vote_average;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setPopularity(float popularity) {
        this.popularity = popularity;
    }
    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }
    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }
    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setOriginal_name(String original_name) {
        this.original_name = original_name;
    }
    public void setGenre_ids(int[] genre_ids) {
        this.genre_ids = genre_ids;
    }
    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }
    public void setAdult(boolean adult) {
        this.adult = adult;
    }
    public void setOverview(String overview) {
        this.overview = overview;
    }
    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }
    public void setFirst_air_date(String first_air_date) {
        this.first_air_date = first_air_date;
    }
    //endregion

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", vote_count=" + vote_count +
                ", video=" + video +
                ", vote_average=" + vote_average +
                ", title='" + title + '\'' +
                ", popularity=" + popularity +
                ", poster_path='" + poster_path + '\'' +
                ", original_language='" + original_language + '\'' +
                ", original_title='" + original_title + '\'' +
                ", name='" + name + '\'' +
                ", original_name='" + original_name + '\'' +
                ", genre_ids=" + Arrays.toString(genre_ids) +
                ", backdrop_path='" + backdrop_path + '\'' +
                ", adult=" + adult +
                ", overview='" + overview + '\'' +
                ", release_date='" + release_date + '\'' +
                ", first_air_date='" + first_air_date + '\'' +
                '}';
    }
}
