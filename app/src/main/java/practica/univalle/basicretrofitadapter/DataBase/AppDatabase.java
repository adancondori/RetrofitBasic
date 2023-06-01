package practica.univalle.basicretrofitadapter.DataBase;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import practica.univalle.basicretrofitadapter.DAO.PokemonDAO;
import practica.univalle.basicretrofitadapter.Models.Pokemon;

@Database(entities = {Pokemon.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract PokemonDAO pokemonDao();
}