package practica.univalle.basicretrofitadapter.Example2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;



public class CustomBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction() != null && intent.getAction().equals(CustomBroadcastIntent.ACTION_CUSTOM_BROADCAST)) {
            String receivedData = intent.getStringExtra(CustomBroadcastIntent.EXTRA_DATA);
            Log.d("CustomBroadcastReceiver", "Received data: " + receivedData);
        }
    }
}