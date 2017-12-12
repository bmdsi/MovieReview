package com.example.moviemagic.core;

import android.content.SharedPreferences;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Shared preference based storage for favorite movies
 * TODO : A better implementation can be DB based (ROOM database)
 */

public class SharedPreferencesUtil {

    SharedPreferences sharedPreferences;
    private static final String PREF_KEY = "fav_key";
    private static final String DELIMITER = "~~";

    public SharedPreferencesUtil(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    /**
     * if movie already in Fav list, removes it else add it
     *
     * @param movieName
     */
    public void updateMovie(String movieName) {
        //if already exists in the list, return
        if (isFav(movieName)) {
            removeFav(movieName);
            return;
        }
        StringBuilder val = new StringBuilder();
        if (sharedPreferences.contains(PREF_KEY)) {
            val.append(sharedPreferences.getString(PREF_KEY, ""))
                    .append(DELIMITER);
        }
        val.append(movieName);
        sharedPreferences.edit().putString(PREF_KEY, val.toString()).apply();
    }

    /**
     * Check if the movie is in the fav list
     *
     * @param movieName
     * @return true if movie already in fav list, else false
     */
    public boolean isFav(String movieName) {
        List<String> favs = geFavMovies();
        if (favs.contains(movieName)) {
            return true;
        }
        return false;
    }

    /**
     * Removes the movie from the fav list
     *
     * @param movieName
     */
    public void removeFav(String movieName) {
        List<String> favs = geFavMovies();
        favs.remove(movieName);
        StringBuilder sb = new StringBuilder();
        for (String s : favs) {
            sb.append(s).append(DELIMITER);
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - DELIMITER.length()); //delete last comma
        }
        sharedPreferences.edit().putString(PREF_KEY, sb.toString()).apply();
    }

    /**
     * All the list of fav movies
     *
     * @return
     */
    public List<String> geFavMovies() {
        String val = sharedPreferences.getString(PREF_KEY, "");
        return new LinkedList<String>(Arrays.asList(val.split(DELIMITER)));
    }
}
