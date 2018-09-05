package com.villa.deimer.pruebatecnicarappi.model.entities;

public class Season {

    private String id;
    private String season_number;
    private String episode_count;
    private String overview;
    private String air_date;
    private String name;

    public Season() {}
    public Season(String id, String season_number, String episode_count, String overview, String air_date, String name) {
        this.id = id;
        this.season_number = season_number;
        this.episode_count = episode_count;
        this.overview = overview;
        this.air_date = air_date;
        this.name = name;
    }

    //region Getters
    public String getId() {
        return id;
    }
    public String getSeason_number() {
        return season_number;
    }
    public String getEpisode_count() {
        return episode_count;
    }
    public String getOverview() {
        return overview;
    }
    public String getAir_date() {
        return air_date;
    }
    public String getName() {
        return name;
    }
    //endregion

    //region Setters
    public void setId(String id) {
        this.id = id;
    }
    public void setSeason_number(String season_number) {
        this.season_number = season_number;
    }
    public void setEpisode_count(String episode_count) {
        this.episode_count = episode_count;
    }
    public void setOverview(String overview) {
        this.overview = overview;
    }
    public void setAir_date(String air_date) {
        this.air_date = air_date;
    }
    public void setName(String name) {
        this.name = name;
    }
    //endregion

    @Override
    public String toString() {
        return "Season{" +
                "id='" + id + '\'' +
                ", season_number='" + season_number + '\'' +
                ", episode_count='" + episode_count + '\'' +
                ", overview='" + overview + '\'' +
                ", air_date='" + air_date + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
