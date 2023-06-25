package practica.univalle.basicretrofitadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivityB extends AppCompatActivity {
    public EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_b);
        editText = findViewById(R.id.editValue);
    }

    public void goClose(View view){
        Intent returnIntent = new Intent();
        returnIntent.putExtra("result",editText.getText().toString());
        setResult(Activity.RESULT_OK,returnIntent);
        finish();
    }
}