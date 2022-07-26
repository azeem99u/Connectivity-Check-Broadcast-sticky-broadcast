package com.example.android.dynamicbroadcastreceiverforconnectivity;

import static com.example.android.dynamicbroadcastreceiverforconnectivity.MainActivity.textView;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

public class ConnectivityCheckBroadcast extends BroadcastReceiver {
    int i = 0;
    @SuppressLint("SetTextI18n")
    @Override
    public void onReceive(Context context, Intent intent) {
        if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())){
            boolean booleanExtra = intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, false);
            if (!booleanExtra){
                Toast.makeText(context, "Connected", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(context, "Disconnected", Toast.LENGTH_SHORT).show();
            }
        }else if (Intent.ACTION_TIME_TICK.equals(intent.getAction())){
            ++i;
            textView.setText("Mints: "+i);
        }
    }
}
