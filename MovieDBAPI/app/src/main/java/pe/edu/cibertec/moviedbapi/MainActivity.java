package pe.edu.cibertec.moviedbapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import au.com.gridstone.rxstore.converters.GsonConverter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    ArrayList<Movie> items;
    MovieAdapter movieAdapter;

    @BindView(R.id.etPokemon)
    EditText etPokemon;
    @BindView(R.id.rvPokemon)
    RecyclerView rvPokemon;

    @OnClick(R.id.btSearch)
    void serarchMovie() {

        String apiKey ="3cae426b920b29ed2fb1c0749f258325";
        String movie = etPokemon.getText().toString();
        Retrofit retrofit =new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/search/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MovieInterface  MovieInterface =retrofit.create(MovieInterface.class);
        Call <MovieResponse> searchMethod = MovieInterface.searchMovies(apiKey,movie);
        searchMethod.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {

                if (response.isSuccessful()){

                    MovieResponse  movieResponse =response.body();
                   items = movieResponse.getMovies();
                }

            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {

            }
        });
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        items=new ArrayList<>();
        movieAdapter=new MovieAdapter(items);
        rvPokemon.setAdapter(movieAdapter);
        rvPokemon.setLayoutManager(new LinearLayoutManager(this));



    }
}
