package practica.univalle.basicretrofitadapter.Example3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import practica.univalle.basicretrofitadapter.R;

public class ActivityB extends AppCompatActivity {
    public TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        textView = findViewById(R.id.textViewB);
        Singleton singleton = Singleton.getInstance();
        singleton.getReceiver().addTExtViews(textView);
    }

    public void goScreen(View view){
        Intent intent=new Intent(this,ActivityC.class);
        startActivity(intent);
    }
}