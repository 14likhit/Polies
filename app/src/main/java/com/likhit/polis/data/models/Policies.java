package com.likhit.polis.data.models;

import com.google.gson.annotations.SerializedName;

public class Policies {

    @SerializedName("id")
    private Integer id;

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String detail;

    @SerializedName("image")
    private String image;

    public Policies() {
    }

    public Policies(Integer id, String name, String detail, String image) {
        this.id = id;
        this.name = name;
        this.detail = detail;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
