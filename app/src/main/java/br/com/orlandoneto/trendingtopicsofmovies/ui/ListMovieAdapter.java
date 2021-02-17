package br.com.orlandoneto.trendingtopicsofmovies.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.orlandoneto.trendingtopicsofmovies.R;
import br.com.orlandoneto.trendingtopicsofmovies.data.modelresponse.MoviesResponse;

public class ListMovieAdapter extends RecyclerView.Adapter<ListMovieAdapter.ListMovieViewHolder> {

    private List<MoviesResponse> movies;

    public ListMovieAdapter(List<MoviesResponse> movies) {
        this.movies = movies;
    }


    @NonNull
    @Override
    public ListMovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_movies, parent, false);

        return new ListMovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListMovieViewHolder holder, int position) {
        holder.bind(movies.get(position));

    }

    @Override
    public int getItemCount() {
        return (movies != null && movies.size() > 0) ? movies.size() : 0;
    }

    static class ListMovieViewHolder extends RecyclerView.ViewHolder {
        private TextView textTitleMovie;
        private ImageView imagePoster;

        public ListMovieViewHolder(@NonNull View itemView) {
            super(itemView);
            textTitleMovie = itemView.findViewById(R.id.text_title_movie);
            imagePoster = itemView.findViewById(R.id.image_poster);


        }

        public void bind(MoviesResponse movie){
            textTitleMovie.setText(movie.getTitle());
            Picasso.get().load("https://image.tmdb.org/t/p/w500/" + movie.getPathPoster()).into(imagePoster);
        }
    }

}
