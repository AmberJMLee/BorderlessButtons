package com.example.android.borderlessbuttons;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by Owner on 2/5/2016.
 */
public class Description extends ListActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Toast.makeText(Description.this,
                "Touched this noise. " + R.id.primary_target,
                Toast.LENGTH_SHORT).show();
        setContentView(R.layout.item_description);
    }
}
