package com.mens.appmens.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by islam on 30/08/17.
 */

public class PeriodsMens {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("clots")
    @Expose
    private Integer clots;
    @SerializedName("cramps")
    @Expose
    private Integer cramps;
    @SerializedName("timestamp")
    @Expose
    private String timestamp;
    @SerializedName("first_day")
    @Expose
    private Boolean firstDay;
    @SerializedName("level")
    @Expose
    private Integer level;
    @SerializedName("color")
    @Expose
    private Integer color;
    @SerializedName("comment")
    @Expose
    private String comment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClots() {
        return clots;
    }

    public void setClots(Integer clots) {
        this.clots = clots;
    }

    public Integer getCramps() {
        return cramps;
    }

    public void setCramps(Integer cramps) {
        this.cramps = cramps;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Boolean getFirstDay() {
        return firstDay;
    }

    public void setFirstDay(Boolean firstDay) {
        this.firstDay = firstDay;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getColor() {
        return color;
    }

    public void setColor(Integer color) {
        this.color = color;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
