package br.com.orlandoneto.trendingtopicsofmovies.data.network;

import br.com.orlandoneto.trendingtopicsofmovies.data.modelresponse.MoviesResult;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieService {

    @GET("movie/popular")
    Call<MoviesResult> obtainMoviePop(@Query("api_key") String apiKey);


}
