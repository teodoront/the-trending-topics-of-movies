package br.com.orlandoneto.trendingtopicsofmovies.data.modelresponse;

import com.squareup.moshi.Json;

import java.util.List;

public class MoviesResult {

@Json(name = "results")
    private final List<MoviesResponse> resultMovies;

    public MoviesResult(List<MoviesResponse> resultMovies) {
        this.resultMovies = resultMovies;
    }

    public List<MoviesResponse> getResultMovies() {
        return resultMovies;
    }
}
