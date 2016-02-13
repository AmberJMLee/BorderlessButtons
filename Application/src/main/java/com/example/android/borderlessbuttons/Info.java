package com.example.android.borderlessbuttons;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

public class Info extends Activity{
    private String value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.popwindow);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        Intent intent = getIntent();
        value = intent.getStringExtra("RESULT_MESSAGE");
        TextView display = (TextView) findViewById(R.id.title);
        display.setText(value);
    }
    @Override
    protected void onResume() {
        super.onResume();

//        int width = dm.widthPixels;
//        int height = dm.heightPixels;
//        getWindow().setLayout((int)(width*1.0), (int)(height*1.0));
    }
}
