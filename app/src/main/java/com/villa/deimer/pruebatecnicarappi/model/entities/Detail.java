package com.villa.deimer.pruebatecnicarappi.model.entities;

import java.util.List;

public class Detail {

    private int id;
    private boolean adult;
    private String backdrop_path;
    private float budget;
    private List<Genre> genres;
    private List<Season> seasons;
    private List<Created> created_by;
    private String homepage;
    private String imdb_id;
    private String original_language;
    private String original_title;
    private String overview;
    private float popularity;
    private String poster_path;
    private List <ProductionCompany> production_companies;
    private List <ObjectPivot> production_countries;
    private String release_date;
    private String first_air_date;
    private float revenue;
    private float runtime;
    private List <ObjectPivot> spoken_languages;
    private String status;
    private String tagline;
    private String title;
    private boolean video;
    private float vote_average;
    private float vote_count;

    public Detail() {}
    public Detail(int id, boolean adult, String backdrop_path, float budget, List<Genre> genres, List<Season> seasons, List<Created> created_by, String homepage, String imdb_id, String original_language, String original_title, String overview, float popularity, String poster_path, List<ProductionCompany> production_companies, List<ObjectPivot> production_countries, String release_date, String first_air_date, float revenue, float runtime, List<ObjectPivot> spoken_languages, String status, String tagline, String title, boolean video, float vote_average, float vote_count) {
        this.id = id;
        this.adult = adult;
        this.backdrop_path = backdrop_path;
        this.budget = budget;
        this.genres = genres;
        this.seasons = seasons;
        this.created_by = created_by;
        this.homepage = homepage;
        this.imdb_id = imdb_id;
        this.original_language = original_language;
        this.original_title = original_title;
        this.overview = overview;
        this.popularity = popularity;
        this.poster_path = poster_path;
        this.production_companies = production_companies;
        this.production_countries = production_countries;
        this.release_date = release_date;
        this.first_air_date = first_air_date;
        this.revenue = revenue;
        this.runtime = runtime;
        this.spoken_languages = spoken_languages;
        this.status = status;
        this.tagline = tagline;
        this.title = title;
        this.video = video;
        this.vote_average = vote_average;
        this.vote_count = vote_count;
    }

    //region Getters
    public int getId() {
        return id;
    }
    public boolean isAdult() {
        return adult;
    }
    public String getBackdrop_path() {
        return backdrop_path;
    }
    public float getBudget() {
        return budget;
    }
    public List<Genre> getGenres() {
        return genres;
    }
    public String getHomepage() {
        return homepage;
    }
    public String getImdb_id() {
        return imdb_id;
    }
    public String getOriginal_language() {
        return original_language;
    }
    public String getOriginal_title() {
        return original_title;
    }
    public String getOverview() {
        return overview;
    }
    public float getPopularity() {
        return popularity;
    }
    public String getPoster_path() {
        return poster_path;
    }
    public List<ProductionCompany> getProduction_companies() {
        return production_companies;
    }
    public List<ObjectPivot> getProduction_countries() {
        return production_countries;
    }
    public String getRelease_date() {
        return release_date;
    }
    public float getRevenue() {
        return revenue;
    }
    public float getRuntime() {
        return runtime;
    }
    public List<ObjectPivot> getSpoken_languages() {
        return spoken_languages;
    }
    public String getStatus() {
        return status;
    }
    public String getTagline() {
        return tagline;
    }
    public String getTitle() {
        return title;
    }
    public boolean isVideo() {
        return video;
    }
    public float getVote_average() {
        return vote_average;
    }
    public float getVote_count() {
        return vote_count;
    }
    public List<Season> getSeasons() {
        return seasons;
    }
    public List<Created> getCreated_by() {
        return created_by;
    }
    public String getFirst_air_date() {
        return first_air_date;
    }
    //endregion

    //region Setters
    public void setId(int id) {
        this.id = id;
    }
    public void setAdult(boolean adult) {
        this.adult = adult;
    }
    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }
    public void setBudget(float budget) {
        this.budget = budget;
    }
    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }
    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }
    public void setImdb_id(String imdb_id) {
        this.imdb_id = imdb_id;
    }
    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }
    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }
    public void setOverview(String overview) {
        this.overview = overview;
    }
    public void setPopularity(float popularity) {
        this.popularity = popularity;
    }
    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }
    public void setProduction_companies(List<ProductionCompany> production_companies) {
        this.production_companies = production_companies;
    }
    public void setProduction_countries(List<ObjectPivot> production_countries) {
        this.production_countries = production_countries;
    }
    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }
    public void setRevenue(float revenue) {
        this.revenue = revenue;
    }
    public void setRuntime(float runtime) {
        this.runtime = runtime;
    }
    public void setSpoken_languages(List<ObjectPivot> spoken_languages) {
        this.spoken_languages = spoken_languages;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setTagline(String tagline) {
        this.tagline = tagline;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setVideo(boolean video) {
        this.video = video;
    }
    public void setVote_average(float vote_average) {
        this.vote_average = vote_average;
    }
    public void setVote_count(float vote_count) {
        this.vote_count = vote_count;
    }
    public void setSeasons(List<Season> seasons) {
        this.seasons = seasons;
    }
    public void setCreated_by(List<Created> created_by) {
        this.created_by = created_by;
    }
    public void setFirst_air_date(String first_air_date) {
        this.first_air_date = first_air_date;
    }
    //endregion

    @Override
    public String toString() {
        return "Detail{" +
                "id=" + id +
                ", adult=" + adult +
                ", backdrop_path='" + backdrop_path + '\'' +
                ", budget=" + budget +
                ", genres=" + genres +
                ", seasons=" + seasons +
                ", created_by=" + created_by +
                ", homepage='" + homepage + '\'' +
                ", imdb_id='" + imdb_id + '\'' +
                ", original_language='" + original_language + '\'' +
                ", original_title='" + original_title + '\'' +
                ", overview='" + overview + '\'' +
                ", popularity=" + popularity +
                ", poster_path='" + poster_path + '\'' +
                ", production_companies=" + production_companies +
                ", production_countries=" + production_countries +
                ", release_date='" + release_date + '\'' +
                ", first_air_date='" + first_air_date + '\'' +
                ", revenue=" + revenue +
                ", runtime=" + runtime +
                ", spoken_languages=" + spoken_languages +
                ", status='" + status + '\'' +
                ", tagline='" + tagline + '\'' +
                ", title='" + title + '\'' +
                ", video=" + video +
                ", vote_average=" + vote_average +
                ", vote_count=" + vote_count +
                '}';
    }
}