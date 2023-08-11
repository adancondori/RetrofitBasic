package practica.univalle.basicretrofitadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;

import practica.univalle.basicretrofitadapter.models.Horse;

public class HorseRaceActivity extends AppCompatActivity {

    private static final int NUM_CABALLOS = 2;

    private ProgressBar[] progressBars = new ProgressBar[NUM_CABALLOS];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horse_race);

        progressBars[0] = findViewById(R.id.horse1);
        progressBars[1] = findViewById(R.id.horse2);

        Button startRaceButton = findViewById(R.id.startRaceButton);
        startRaceButton.setOnClickListener(v -> startRace());
    }

    private void startRace() {
        for (int i = 0; i < NUM_CABALLOS; i++) {
            new Thread(new Horse(progressBars[i])).start();
        }
    }

}