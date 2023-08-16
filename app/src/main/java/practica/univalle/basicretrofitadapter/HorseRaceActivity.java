package practica.univalle.basicretrofitadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import practica.univalle.basicretrofitadapter.models.Horse;

public class HorseRaceActivity extends AppCompatActivity {
    private static final int NUM_CABALLOS = 2;
    private Horse[] horses = new Horse[NUM_CABALLOS];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horse_race);

        LinearLayout layout = findViewById(R.id.horsesLayout);
        for (int i = 0; i < NUM_CABALLOS; i++) {
            View horseView = getLayoutInflater().inflate(R.layout.horse_layout, layout, false);
            horses[i] = new Horse(horseView);
            layout.addView(horseView);
        }

        Button startRaceButton = findViewById(R.id.startRaceButton);
        startRaceButton.setOnClickListener(v -> startRace());
    }

    private void startRace() {
        for (Horse horse : horses) {
            new Thread(horse).start();
        }
    }
}