package practica.univalle.basicretrofitadapter.Example1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.TextView;

public class MyReceiver  extends BroadcastReceiver {
    public TextView textView;

    public MyReceiver() {
    }

    public MyReceiver(TextView textView) {
        this.textView = textView;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("TAG", "onReceive: ");
        if (intent.getAction() != null && intent.getAction().equals(MainActivity.CUSTOM_BROADCAST_ACTION)) {
            textView.setText("Broadcast recibido!");
        }
    }
}
