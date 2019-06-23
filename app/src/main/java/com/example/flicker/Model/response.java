package com.example.flicker.Model;

import com.example.flicker.Model.Photos;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class response {
    @SerializedName("photos")
    @Expose
    public Photos photos;
    @SerializedName("stat")
    @Expose
    public String stat;
}
