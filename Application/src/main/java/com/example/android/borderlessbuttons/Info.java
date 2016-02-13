package com.example.android.borderlessbuttons;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;

public class Info extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.popwindow);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

//        int width = dm.widthPixels;
//        int height = dm.heightPixels;
//        getWindow().setLayout((int)(width*1.0), (int)(height*1.0));
    }
}
