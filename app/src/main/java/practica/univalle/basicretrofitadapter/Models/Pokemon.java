package practica.univalle.basicretrofitadapter.Models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Pokemon {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public int weight;
    public String name;
    public String url;

    public Pokemon(int id, int weight, String name, String url) {
        this.id = id;
        this.weight = weight;
        this.name = name;
        this.url = url;
    }
}

