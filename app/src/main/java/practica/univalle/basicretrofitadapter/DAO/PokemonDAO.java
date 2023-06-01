package practica.univalle.basicretrofitadapter.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import practica.univalle.basicretrofitadapter.Models.Pokemon;

@Dao
public interface PokemonDAO {
    @Query("SELECT * FROM pokemon")
    List<Pokemon> getAll();

    @Insert
    void insertAll(Pokemon... pokemons);
}