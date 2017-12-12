package com.example.moviemagic.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by kumar on 12/9/17.
 */

//TODO implement parcelable
@Entity(tableName="MovieData")
public class MovieData implements Serializable {

    public MovieData(String displayTitle, String movieRating, String headline, String shortSummary, String openingDate) {
        this.displayTitle = displayTitle;
        this.movieRating = movieRating;
        this.headline = headline;
        this.shortSummary = shortSummary;
        this.openingDate = openingDate;
    }

    @PrimaryKey
    @NonNull
    @SerializedName("display_title")
    public String displayTitle;

    @SerializedName("mpaa_rating")
    public String movieRating;

    public String headline;

    @SerializedName("summary_short")
    public String shortSummary;

    @SerializedName("opening_date")
    public String openingDate;

    @Ignore
    public Link link;

    @Ignore
    public Multimedia multimedia;


    public String getDisplayTitle() {
        return displayTitle;
    }

    public String getHeadline() {
        return headline;
    }

    public String getOpeningDate() {
        return openingDate;
    }

    public String getShortSummary() {
        return shortSummary;
    }

    public String getImageUrl() {
        return multimedia.src;
    }

    public String getLinkUrl() {
        return link.url;
    }

    class Link implements Serializable {
        String type;
        String url;

        @SerializedName("suggested_link_text")
        String suggestedLinkText;
    }

    class Multimedia implements Serializable {
        String type;
        String src;
    }


}
