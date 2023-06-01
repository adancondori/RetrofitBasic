package practica.univalle.basicretrofitadapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import practica.univalle.basicretrofitadapter.Adapters.UserAdapter;
import practica.univalle.basicretrofitadapter.Models.Pokemon;
import practica.univalle.basicretrofitadapter.Service.PokemonResponse;
import practica.univalle.basicretrofitadapter.Service.ConectionAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Pokemon> pokemonList;
    private UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initAdapter();
        getPokemonAPI();
    }

    public void initAdapter(){
        pokemonList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        userAdapter = new UserAdapter(this, pokemonList);
        recyclerView.setAdapter(userAdapter);
    }

    private void getPokemonAPI() {
        Call<PokemonResponse> call = ConectionAPI.getConectionAPI().getPokemon(1);
        call.enqueue(new Callback<PokemonResponse>() {
            @Override
            public void onResponse(Call<PokemonResponse> call, Response<PokemonResponse> response) {
                if (response.isSuccessful()) {
                    Pokemon pokemon = response.body().getPokemon();
                    pokemonList.add(pokemon);
                    userAdapter.notifyDataSetChanged();
                } else {
                    Log.e("MainActivity", "Error al obtener la lista de películas: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<PokemonResponse> call, Throwable t) {
                Log.e("MainActivity", "onFailure al obtener la lista de películas: " + t.toString());
            }
        });
        /*
        Call<PokemonResponse> call = ConectionAPI.getMovieAPI().getPokemon();
        call.enqueue(new Callback<PokemonResponse>() {
            @Override
            public void onResponse(Call<PokemonResponse> call, Response<PokemonResponse> response) {
                if (response.isSuccessful()) {
                    pokemonList.addAll(response.body().getUser());
                    userAdapter.notifyDataSetChanged();
                } else {
                    Log.e("MainActivity", "Error al obtener la lista de películas: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<PokemonResponse> call, Throwable t) {
                Log.e("MainActivity", "Error al obtener la lista de películas: " + t.getMessage());
            }
        });
         */
    }
    private void getUserPerPage() {
        /*
        Call<PokemonResponse> call = ConectionAPI.getMovieAPI().getUserPerPage(1,12);
        call.enqueue(new Callback<PokemonResponse>() {
            @Override
            public void onResponse(Call<PokemonResponse> call, Response<PokemonResponse> response) {
                if (response.isSuccessful()) {
                    pokemonList.addAll(response.body().getUser());
                    userAdapter.notifyDataSetChanged();
                } else {
                    Log.e("MainActivity", "Error al obtener la lista de películas: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<PokemonResponse> call, Throwable t) {
                Log.e("MainActivity", "Error al obtener la lista de películas: " + t.getMessage());
            }
        });
         */
    }
/*
    public void initUsers(){
        userList.add(new User(1,"matatan@gmail.com","Andres","Pereira","https://reqres.in/img/faces/1-image.jpg"));
        userList.add(new User(2,"matatan1@gmail.com","Pero","Pereira","https://reqres.in/img/faces/3-image.jpg"));
        userList.add(new User(3,"matatan2@gmail.com","marco","Pereira","https://reqres.in/img/faces/5-image.jpg"));
        userList.add(new User(4,"matatan3@gmail.com","Juanes","Pereira","https://reqres.in/img/faces/6-image.jpg"));
        userList.add(new User(5,"matatan4@gmail.com","Terry","Pereira","https://reqres.in/img/faces/7-image.jpg"));
        userList.add(new User(6,"matatan5@gmail.com","Valdomero","Pereira","https://reqres.in/img/faces/4-image.jpg"));
        userList.add(new User(7,"matatan6@gmail.com","Juan","Pereira","https://reqres.in/img/faces/4-image.jpg"));
        userList.add(new User(8,"matatan7@gmail.com","Jhon","Pereira","https://reqres.in/img/faces/4-image.jpg"));
        userList.add(new User(9,"matatan@gmail.com","Andres","Pereira","https://reqres.in/img/faces/4-image.jpg"));
    }
 */
}