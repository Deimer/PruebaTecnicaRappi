package com.villa.deimer.pruebatecnicarappi.model.entities;

public class Genre {

    private float id;
    private String name;

    public Genre() {}
    public Genre(float id, String name) {
        this.id = id;
        this.name = name;
    }

    //region Getters
    public float getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    //endregion

    //region Setters
    public void setId(float id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    //endregion

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
