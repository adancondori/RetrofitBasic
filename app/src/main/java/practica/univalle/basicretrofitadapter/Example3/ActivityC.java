package practica.univalle.basicretrofitadapter.Example3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import practica.univalle.basicretrofitadapter.R;

public class ActivityC extends AppCompatActivity {
    public TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);
        textView = findViewById(R.id.textViewC);
        Singleton singleton = Singleton.getInstance();
        singleton.getReceiver().addTExtViews(textView);
    }
    public void goScreen(View view){
        Intent intent=new Intent(this,ActivityD.class);
        startActivity(intent);
    }
}