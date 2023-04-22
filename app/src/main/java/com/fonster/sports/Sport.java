package com.fonster.sports;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sport {
    @SerializedName("id")
    @Expose
    int id;

    @SerializedName("name")
    @Expose
    String name;

    @SerializedName("name_ru")
    @Expose
    String name_ru;

    @SerializedName("name_en")
    @Expose
    String name_en;

    @SerializedName("counter")
    @Expose
    int counter;
}
