package practica.univalle.basicretrofitadapter.Example2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import practica.univalle.basicretrofitadapter.R;

public class BCMainActivity extends AppCompatActivity {
    private CustomBroadcastReceiver dynamicReceiver;
    public TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bcmain);
        textView = findViewById(R.id.textView);
        dynamicReceiver = new CustomBroadcastReceiver();
        registerReceiver(dynamicReceiver, CustomBroadcastIntent.createFilter());
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(dynamicReceiver);
    }

    public void sendCustomBroadcast(View view) {
        String dataToSend = "Hello, this is a custom broadcast!";
        Intent customBroadcastIntent = CustomBroadcastIntent.createIntent(dataToSend);
        sendOrderedBroadcast(customBroadcastIntent, null);
    }
}