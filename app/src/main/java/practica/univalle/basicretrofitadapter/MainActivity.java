package practica.univalle.basicretrofitadapter;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.activity.result.contract.ActivityResultContracts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_B = 2;
    private static final int REQUEST_CODE_C = 3;

    public TextView txtTitle;
    public TextView txtValue;
    ActivityResultLauncher<Intent> activityResultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtTitle = findViewById(R.id.txtTitle);
        txtValue = findViewById(R.id.txtValue);
        activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        // Obtener el resultado de la actividad secundaria
                        Intent data = result.getData();
                        if (data != null) {
                            // Extraer los datos devueltos por la actividad secundaria
                            String resultado = data.getStringExtra("resultado");
                            txtTitle.setText(resultado);
                            txtValue.setText(resultado);

                        }

                    }
                }
        );
    }

    public void goScreenB(View view){
        Intent i = new Intent(this, MainActivityB.class);
        activityResultLauncher.launch(i);
    }

    public void goScreenC(View view){
        Intent i = new Intent(this, MainActivityB.class);
        activityResultLauncher.launch(i);
    }
}