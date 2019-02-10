package pe.edu.cibertec.moviedbapi;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;


class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.LayoutMovie> {

    ArrayList<Movie> movies;

    public MovieAdapter(ArrayList<Movie> movies) {
        this.movies = movies;
    }
    @NonNull
    @Override

    public LayoutMovie onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext())
                .from(viewGroup.getContext())
                .inflate(R.layout.Movie_layout, viewGroup,false);

        LayoutMovie layoutMovie = new LayoutMovie(view);
        return layoutMovie;
    }

    @Override
    public void onBindViewHolder(@NonNull LayoutMovie layoutMovie, int position) {

        layoutMovie.tvName.setText(movies.get(position).getTittle());
        layoutMovie.tvAltura.setText(movies.get(position).getReleaseDate());
        layoutMovie.tvPeso.setText(movies.get(position).getOverview());

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }


    class LayoutMovie extends RecyclerView.ViewHolder {
        @BindView(R.id.tvName)
        TextView tvName;

        @BindView(R.id.tvAltura)
        TextView tvAltura;

        @BindView(R.id.tvPeso)
        TextView tvPeso;

        @BindView(R.id.ibPokemon)
        ImageView ibpokemon;

        public LayoutMovie(@NonNull View itemView) {
            super(itemView);

        }
    }
}
