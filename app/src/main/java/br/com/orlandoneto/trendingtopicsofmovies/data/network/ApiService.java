package br.com.orlandoneto.trendingtopicsofmovies.data.network;

import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class ApiService {

    private static MovieService INSTANCE;

    public static MovieService getInsatance(){
        if (INSTANCE == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.themoviedb.org/3/")
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build();

            INSTANCE  = retrofit.create(MovieService.class);

        }return INSTANCE;
    }

}
