package practica.univalle.basicretrofitadapter.Example3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import practica.univalle.basicretrofitadapter.Example2.CustomBroadcastIntent;
import practica.univalle.basicretrofitadapter.Example2.CustomBroadcastReceiver;
import practica.univalle.basicretrofitadapter.R;
public class ActivityA extends AppCompatActivity {
    private BroadCastReceiver receiver;
    public TextView textView;
    public Singleton singleton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity);
        textView = findViewById(R.id.textViewA);
        singleton = Singleton.getInstance();
        receiver = new BroadCastReceiver();
        singleton.setDynamicReceiver(receiver);
        singleton.getReceiver().addTExtViews(textView);
        registerReceiver(receiver, new IntentFilter(BroadCastReceiver.ACTION_UPDATE_ACTIVITY));
    }

    public void goScreen(View view){
        Intent intent=new Intent(this,ActivityB.class);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }
}