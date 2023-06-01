package practica.univalle.basicretrofitadapter.Service;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import practica.univalle.basicretrofitadapter.Models.Pokemon;


public class PokemonResponse {
    @SerializedName("id")
    public int id;
    @SerializedName("weight")
    public int weight;
    @SerializedName("name")
    public String name;
    @SerializedName("form")
    public Form form = new Form("","");
    @SerializedName("sprites")
    public Sprites sprites = new Sprites();
    @Expose(serialize = false, deserialize = false)
    public Pokemon pokemon;

    public Pokemon getPokemon() {
        pokemon = new Pokemon(this.id, this.weight, this.name, this.sprites.other.home.front_shiny);
        return pokemon;
    }

    public class Form {
        public String name;
        public String url;
        public Form(String name, String url) {
            this.name = name;
            this.url = url;
        }
    }
    public class Sprites {

        public Other other;

        // Getters and setters
        public Other getOther() {
            return other;
        }

        public void setOther(Other other) {
            this.other = other;
        }

    }

    public class Other {

        public Home home;

        // Getters and setters
        public Home getHome() {
            return home;
        }

        public void setHome(Home home) {
            this.home = home;
        }

    }

    public class Home {

        public String front_default;
        public Object front_female;
        public String front_shiny;
        public Object front_shiny_female;

        // Getters and setters
        public String getFrontDefault() {
            return front_default;
        }

        public void setFrontDefault(String front_default) {
            this.front_default = front_default;
        }

        public Object getFrontFemale() {
            return front_female;
        }

        public void setFrontFemale(Object front_female) {
            this.front_female = front_female;
        }

        public String getFrontShiny() {
            return front_shiny;
        }

        public void setFrontShiny(String front_shiny) {
            this.front_shiny = front_shiny;
        }

        public Object getFrontShinyFemale() {
            return front_shiny_female;
        }

        public void setFrontShinyFemale(Object front_shiny_female) {
            this.front_shiny_female = front_shiny_female;
        }

    }

}
