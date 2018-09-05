package com.villa.deimer.pruebatecnicarappi.model.entities;

public class Video {

    private String id;
    private String iso_639_1;
    private String iso_3166_1;
    private String key;
    private String name;
    private String site;
    private float size;
    private String type;

    public Video() {}
    public Video(String id, String iso_639_1, String iso_3166_1, String key, String name, String site, float size, String type) {
        this.id = id;
        this.iso_639_1 = iso_639_1;
        this.iso_3166_1 = iso_3166_1;
        this.key = key;
        this.name = name;
        this.site = site;
        this.size = size;
        this.type = type;
    }

    //region Getters
    public String getId() {
        return id;
    }
    public String getIso_639_1() {
        return iso_639_1;
    }
    public String getIso_3166_1() {
        return iso_3166_1;
    }
    public String getKey() {
        return key;
    }
    public String getName() {
        return name;
    }
    public String getSite() {
        return site;
    }
    public float getSize() {
        return size;
    }
    public String getType() {
        return type;
    }
    //endregion

    //region Setters
    public void setId(String id) {
        this.id = id;
    }
    public void setIso_639_1(String iso_639_1) {
        this.iso_639_1 = iso_639_1;
    }
    public void setIso_3166_1(String iso_3166_1) {
        this.iso_3166_1 = iso_3166_1;
    }
    public void setKey(String key) {
        this.key = key;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSite(String site) {
        this.site = site;
    }
    public void setSize(float size) {
        this.size = size;
    }
    public void setType(String type) {
        this.type = type;
    }
    //endregion

    @Override
    public String toString() {
        return "Video{" +
                "id='" + id + '\'' +
                ", iso_639_1='" + iso_639_1 + '\'' +
                ", iso_3166_1='" + iso_3166_1 + '\'' +
                ", key='" + key + '\'' +
                ", name='" + name + '\'' +
                ", site='" + site + '\'' +
                ", size=" + size +
                ", type='" + type + '\'' +
                '}';
    }
}
