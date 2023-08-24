package practica.univalle.basicretrofitadapter.Example3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import practica.univalle.basicretrofitadapter.R;

public class ActivityD extends AppCompatActivity {
    EditText editTextA;
    EditText editTextB;
    EditText editTextC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d);
        editTextA = findViewById(R.id.editTextA);
        editTextB = findViewById(R.id.editTextB);
        editTextC = findViewById(R.id.editTextC);
    }
    public void publicar(View view){
        ArrayList<String> newData = new ArrayList<>();
        newData.add(editTextA.getText().toString());
        newData.add(editTextB.getText().toString());
        newData.add(editTextC.getText().toString());
        Intent updateIntent = new Intent(BroadCastReceiver.ACTION_UPDATE_ACTIVITY);
        updateIntent.putStringArrayListExtra(BroadCastReceiver.EXTRA_DATA, newData);
        sendBroadcast(updateIntent);
    }
}