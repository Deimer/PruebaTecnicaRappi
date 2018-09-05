package com.villa.deimer.pruebatecnicarappi.model.entities;

public class ProductionCompany {

    private float id;
    private String logo_path;
    private String name;
    private String origin_country;

    public ProductionCompany() {}
    public ProductionCompany(float id, String logo_path, String name, String origin_country) {
        this.id = id;
        this.logo_path = logo_path;
        this.name = name;
        this.origin_country = origin_country;
    }

    //region Getters
    public float getId() {
        return id;
    }
    public String getLogo_path() {
        return logo_path;
    }
    public String getName() {
        return name;
    }
    public String getOrigin_country() {
        return origin_country;
    }
    //endregion

    //region Setters
    public void setId(float id) {
        this.id = id;
    }
    public void setLogo_path(String logo_path) {
        this.logo_path = logo_path;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setOrigin_country(String origin_country) {
        this.origin_country = origin_country;
    }
    //endregion

    @Override
    public String toString() {
        return "ProductionCompany{" +
                "id=" + id +
                ", logo_path='" + logo_path + '\'' +
                ", name='" + name + '\'' +
                ", origin_country='" + origin_country + '\'' +
                '}';
    }
}
