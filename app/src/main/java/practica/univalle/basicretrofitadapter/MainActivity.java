package practica.univalle.basicretrofitadapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

import practica.univalle.basicretrofitadapter.Adapters.UserAdapter;
import practica.univalle.basicretrofitadapter.DataBase.AppDatabase;
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
    Button btnSave;
    Button btnFind;
    Pokemon pokemon;
    EditText txtIDPoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initAdapter();
        getPokemonAPI(1);
    }

    public void initAdapter(){
        pokemonList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        userAdapter = new UserAdapter(this, pokemonList);
        recyclerView.setAdapter(userAdapter);

        btnSave = findViewById(R.id.button);
        btnFind = findViewById(R.id.btnFind);
        txtIDPoke = findViewById(R.id.txtIDPoke);
        btnFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPokemonAPI(Integer.valueOf(txtIDPoke.getText().toString()));
            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                savePokemon();
            }
        });
    }

    private void getPokemonAPI(int id) {
        Call<PokemonResponse> call = ConectionAPI.getConectionAPI().getPokemon(id);
        call.enqueue(new Callback<PokemonResponse>() {
            @Override
            public void onResponse(Call<PokemonResponse> call, Response<PokemonResponse> response) {
                if (response.isSuccessful()) {
                    pokemonList.clear();
                    pokemon = response.body().getPokemon();
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
    }
    public void savePokemon(){
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "database-name").build();
                db.pokemonDao().insertAll(pokemon);

                List<Pokemon> pokemones = db.pokemonDao().getAll();
                for (Pokemon pokemonx:pokemones) {
                    System.out.println(pokemonx.name);
                }
            }
        });

    }

}