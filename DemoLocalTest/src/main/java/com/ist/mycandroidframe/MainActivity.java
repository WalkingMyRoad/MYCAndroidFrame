package com.ist.mycandroidframe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import hugo.weaving.DebugLog;


@DebugLog
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
