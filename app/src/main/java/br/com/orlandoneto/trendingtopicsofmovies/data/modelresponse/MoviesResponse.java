package br.com.orlandoneto.trendingtopicsofmovies.data.modelresponse;

import com.squareup.moshi.Json;

public class MoviesResponse {

    @Json(name = "poster_path")
    private final String pathPoster;
    @Json(name = "title")
    private final String title;

    public MoviesResponse(String pathPoster, String titleOriginal) {
        this.pathPoster = pathPoster;
        this.title = titleOriginal;
    }


    public String getPathPoster() {
        return pathPoster;
    }

    public String getTitle() {
        return title;
    }
}
