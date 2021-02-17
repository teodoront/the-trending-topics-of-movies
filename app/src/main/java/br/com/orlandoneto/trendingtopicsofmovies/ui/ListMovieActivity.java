package br.com.orlandoneto.trendingtopicsofmovies.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import br.com.orlandoneto.trendingtopicsofmovies.R;
import br.com.orlandoneto.trendingtopicsofmovies.data.network.ApiService;
import br.com.orlandoneto.trendingtopicsofmovies.data.modelresponse.MoviesResult;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListMovieActivity extends AppCompatActivity {
    private Context context;
    private RecyclerView recyclerMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTheme(R.style.Theme_TrendingTopicsOfMovies);
        setContentView(R.layout.activity_list_movie);
        recyclerMovie = findViewById(R.id.recycler_movies);

        splashScreen();
        apiService();

    }

    private void splashScreen() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void apiService() {
        ApiService.getInsatance().obtainMoviePop("9e79ad440f4262f58377a096a5395306")
                .enqueue(new Callback<MoviesResult>() {
                    @Override
                    public void onResponse(Call<MoviesResult> call, Response<MoviesResult> response) {
                        if(response.isSuccessful()){
                            RecyclerView.LayoutManager gridLayoutManager = new GridLayoutManager(context, 2);
                            recyclerMovie.setLayoutManager(gridLayoutManager);
                            recyclerMovie.setAdapter(new ListMovieAdapter(response.body().getResultMovies()));
                        }
                    }

                    @Override
                    public void onFailure(Call<MoviesResult> call, Throwable t) {
                        Toast.makeText(context, "Erro ao acessar a API", Toast.LENGTH_LONG).show();
                    }
                });
    }


}