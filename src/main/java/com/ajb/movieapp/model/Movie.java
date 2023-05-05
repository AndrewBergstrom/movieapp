package com.ajb.movieapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

@Getter
@Setter
public class Movie {
    @JsonProperty("Title")
    private String title;
    @JsonProperty("Plot")
    private String plot;
    @JsonProperty("Rated")
    private String rated;
    @JsonProperty("Released")
    private String released;
    @JsonProperty("Genre")
    private String genre;
    @JsonProperty("Actors")
    private String actors;
//    @JsonProperty("Ratings")
//    private ArrayList<String> ratings;
    private String imdbID;
    private String imdbRating;
    private String imdbVotes;


}
