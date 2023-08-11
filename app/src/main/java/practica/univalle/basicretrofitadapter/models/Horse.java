package practica.univalle.basicretrofitadapter.models;

import android.widget.ProgressBar;

public class Horse implements Runnable {
    private final ProgressBar progressBar;
    private static final int MAX_PROGRESS = 100;

    public Horse(ProgressBar progressBar) {
        this.progressBar = progressBar;
    }

    @Override
    public void run() {
        int progress = 0;
        while (progress < MAX_PROGRESS) {
            try {
                Thread.sleep((long) (Math.random() * 200));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            progress += (int) (Math.random() * 10);
            int finalProgress = Math.min(progress, MAX_PROGRESS);
            progressBar.post(() -> progressBar.setProgress(finalProgress));
        }
    }
}