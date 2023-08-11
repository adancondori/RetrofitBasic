package practica.univalle.basicretrofitadapter.models;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import practica.univalle.basicretrofitadapter.R;

public class Horse implements Runnable {
    private final ImageView horseImage;
    public LinearLayout horsesLayout;
    private static final int MAX_DISTANCE = 1000;

    public Horse(View view) {
        horseImage = view.findViewById(R.id.horseImage);
        horsesLayout = view.findViewById(R.id.racetrackLayout);
    }

    @Override
    public void run() {
        int distance = 0;
        while (distance < MAX_DISTANCE) {
            try {
                Thread.sleep((long) (Math.random() * 200)); // Simula el tiempo que tarda el caballo en avanzar
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            distance += (int) (Math.random() * 10); // Simula la distancia que avanza el caballo
            int finalDistance = Math.min(distance, MAX_DISTANCE);
            float progress = (float) finalDistance / MAX_DISTANCE;
            horseImage.post(() -> {
                LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) horseImage.getLayoutParams();
                params.leftMargin = (int) (progress * (horsesLayout.getWidth() - horseImage.getWidth()));
                horseImage.setLayoutParams(params);
            }); // Actualiza la posición de la imagen
        }
    }
}