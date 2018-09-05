package com.villa.deimer.pruebatecnicarappi.model.entities;

public class Created {

    private String id;
    private String credit_id;
    private String name;
    private String gender;
    private String profile_path;

    public Created() {}
    public Created(String id, String credit_id, String name, String gender, String profile_path) {
        this.id = id;
        this.credit_id = credit_id;
        this.name = name;
        this.gender = gender;
        this.profile_path = profile_path;
    }

    //region Getters
    public String getId() {
        return id;
    }
    public String getCredit_id() {
        return credit_id;
    }
    public String getName() {
        return name;
    }
    public String getGender() {
        return gender;
    }
    public String getProfile_path() {
        return profile_path;
    }
    //endregion

    //region Setters
    public void setId(String id) {
        this.id = id;
    }
    public void setCredit_id(String credit_id) {
        this.credit_id = credit_id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setProfile_path(String profile_path) {
        this.profile_path = profile_path;
    }
    //endregion

    @Override
    public String toString() {
        return "Created{" +
                "id='" + id + '\'' +
                ", credit_id='" + credit_id + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", profile_path='" + profile_path + '\'' +
                '}';
    }
}
