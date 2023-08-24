package practica.univalle.basicretrofitadapter;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import practica.univalle.basicretrofitadapter.Example1.MainActivity;
import practica.univalle.basicretrofitadapter.Example2.BCMainActivity;
import practica.univalle.basicretrofitadapter.Example3.ActivityA;


public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
    }

    public void gotBroadcast1(View view){
        Intent intent = new Intent(PrincipalActivity.this, MainActivity.class);
        startActivity(intent);
    }
    public void gotBroadcast2(View view){
        Intent intent = new Intent(PrincipalActivity.this, BCMainActivity.class);
        startActivity(intent);
    }
    public void gotExample3(View view){
        Intent intent = new Intent(PrincipalActivity.this, ActivityA.class);
        startActivity(intent);
    }
}