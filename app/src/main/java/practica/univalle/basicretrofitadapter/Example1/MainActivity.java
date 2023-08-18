package practica.univalle.basicretrofitadapter.Example1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import practica.univalle.basicretrofitadapter.Example1.MyReceiver;
import practica.univalle.basicretrofitadapter.R;

public class MainActivity extends AppCompatActivity {
    public static final String CUSTOM_BROADCAST_ACTION = "practica.univalle.basicretrofitadapter";
    private MyReceiver myReceiver;
    public TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button broadcastButton = findViewById(R.id.broadcast_button);
        textView = findViewById(R.id.result_text);
        broadcastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent customBroadcastIntent = new Intent(CUSTOM_BROADCAST_ACTION);
                sendBroadcast(customBroadcastIntent);
            }
        });
        if (myReceiver == null) {
            myReceiver = new MyReceiver(textView);
            IntentFilter intentFilter = new IntentFilter(CUSTOM_BROADCAST_ACTION);
            registerReceiver(myReceiver, intentFilter);
        }
    }
}