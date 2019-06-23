package com.example.flicker.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Photo {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("owner")
    @Expose
    private String owner;
    @SerializedName("secret")
    @Expose
    private String secret;
    @SerializedName("server")
    @Expose
    private String server;
    @SerializedName("farm")
    @Expose
    private Integer farm;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("ispublic")
    @Expose
    private Integer ispublic;
    @SerializedName("isfriend")
    @Expose
    private Integer isfriend;
    @SerializedName("isfamily")
    @Expose
    private Integer isfamily;
    @SerializedName("url_s")
    @Expose
    private String urlS;
    @SerializedName("height_s")
    @Expose
    private String heightS;
    @SerializedName("width_s")
    @Expose
    private String widthS;

    public String getOwner() {
        return owner;
    }

    public String getTitle() {
        return title;
    }

    public String getUrlS() {
        return urlS;
    }

}
