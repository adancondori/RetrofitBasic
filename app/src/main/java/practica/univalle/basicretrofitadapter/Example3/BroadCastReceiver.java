package practica.univalle.basicretrofitadapter.Example3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import practica.univalle.basicretrofitadapter.Example2.CustomBroadcastIntent;

public class BroadCastReceiver  extends BroadcastReceiver {
    public static final String ACTION_UPDATE_ACTIVITY = "com.example.UPDATE_ACTIVITY";
    public static final String EXTRA_DATA = "data";
    List<TextView> textViews= new ArrayList<>();
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction() != null && intent.getAction().equals(ACTION_UPDATE_ACTIVITY)) {
            ArrayList<String> receivedData = intent.getStringArrayListExtra(EXTRA_DATA);
            Log.d("CustomBroadcastReceiver", "Received data: " + receivedData);
            updateUI(receivedData);
        }
    }

    public void addTExtViews(TextView textView) {
        textViews.add(textView);
    }

    private void updateUI(List<String> data) {
        for (int i = 0; i < data.size(); i++) {
            textViews.get(i).setText(data.get(i));
        }
    }
}