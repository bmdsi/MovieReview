package com.example.moviemagic.data;

public class MovieDataBuilder {
    private String displayTitle;
    private String movieRating;
    private String headline;
    private String shortSummary;
    private String openingDate;

    public MovieDataBuilder setDisplayTitle(String displayTitle) {
        this.displayTitle = displayTitle;
        return this;
    }

    public MovieDataBuilder setMovieRating(String movieRating) {
        this.movieRating = movieRating;
        return this;
    }

    public MovieDataBuilder setHeadline(String headline) {
        this.headline = headline;
        return this;
    }

    public MovieDataBuilder setShortSummary(String shortSummary) {
        this.shortSummary = shortSummary;
        return this;
    }

    public MovieDataBuilder setOpeningDate(String openingDate) {
        this.openingDate = openingDate;
        return this;
    }

    public MovieData createMovieData() {
        return new MovieData(displayTitle, movieRating, headline, shortSummary, openingDate);
    }
}