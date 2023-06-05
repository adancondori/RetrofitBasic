package practica.univalle.basicretrofitadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

import practica.univalle.basicretrofitadapter.adapters.GridAdapter;
import practica.univalle.basicretrofitadapter.models.Items;

public class MainActivity extends AppCompatActivity {
    public  ArrayList<Items> itemsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init() {
        itemsList = new ArrayList<>();
        itemsList.add(new Items(R.drawable.bumble, "image_1"));
        itemsList.add(new Items(R.drawable.bumble, "image_2"));
        itemsList.add(new Items(R.drawable.bumble, "image_3"));
        itemsList.add(new Items(R.drawable.bumble, "image_4"));
        itemsList.add(new Items(R.drawable.bumble, "image_5"));
        itemsList.add(new Items(R.drawable.bumble, "image_6"));
        itemsList.add(new Items(R.drawable.bumble, "image_7"));
        itemsList.add(new Items(R.drawable.bumble, "image_8"));
        itemsList.add(new Items(R.drawable.bumble, "image_9"));
        itemsList.add(new Items(R.drawable.bumble, "image_10"));

        GridView gridView = findViewById(R.id.grid_view);
        GridAdapter customAdapter = new GridAdapter(this, R.layout.cell_grid, itemsList);
        gridView.setAdapter(customAdapter);
    }
}