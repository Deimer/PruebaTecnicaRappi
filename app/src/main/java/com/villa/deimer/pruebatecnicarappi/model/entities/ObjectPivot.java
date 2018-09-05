package com.villa.deimer.pruebatecnicarappi.model.entities;

import com.google.gson.annotations.SerializedName;

public class ObjectPivot {

    @SerializedName(value = "iso_3166_1", alternate = "iso_639_1")
    private String iso;
    private String name;

    public ObjectPivot() {}
    public ObjectPivot(String iso, String name) {
        this.iso = iso;
        this.name = name;
    }

    //region Getters
    public String getIso() {
        return iso;
    }
    public String getName() {
        return name;
    }
    //endregion

    //region Setters
    public void setIso(String iso) {
        this.iso = iso;
    }
    public void setName(String name) {
        this.name = name;
    }
    //endregion

    @Override
    public String toString() {
        return "ObjectPivot{" +
                "iso='" + iso + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
