package com.example.android.dynamicbroadcastreceiverforconnectivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static TextView textView;

    ConnectivityCheckBroadcast connectivityCheckBroadcast = new ConnectivityCheckBroadcast();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        intentFilter.addAction(Intent.ACTION_TIME_TICK);
        registerReceiver(connectivityCheckBroadcast,intentFilter);
        textView = findViewById(R.id.textView);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(connectivityCheckBroadcast);
    }
}