package practica.univalle.basicretrofitadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor accelerometer;
    private TextView positionTextView;
    private TextView lblPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        positionTextView = findViewById(R.id.lblSensor);
        lblPosition = findViewById(R.id.lblPosition);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];

            String position;
            if (Math.abs(x) > Math.abs(y) && Math.abs(x) > Math.abs(z)) {
                if (x > 0) {
                    position = "Derecha";
                } else {
                    position = "Izquierda";
                }
            } else if (Math.abs(y) > Math.abs(x) && Math.abs(y) > Math.abs(z)) {
                if (y > 0) {
                    position = "Arriba";
                } else {
                    position = "Abajo";
                }
            } else {
                if (z > 0) {
                    position = "Cara arriba";
                } else {
                    position = "Cara abajo";
                }
            }
            String mensaje = String.format("Posición  X: %f   Y: %f  Z: %f", x, y, z);

            lblPosition.setText(mensaje);
            positionTextView.setText("Posición: " + position);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // No se utiliza en este ejemplo
    }
}