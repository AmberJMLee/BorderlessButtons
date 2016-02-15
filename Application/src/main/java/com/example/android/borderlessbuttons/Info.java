package com.example.android.borderlessbuttons;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Info extends Activity{
    public static final String PREFS_NAME = "PrefsFile";
    private String value;
    private String details;
    private String completed;
    private int position;
    private int number = 0;
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

        details = intent.getStringExtra("INFO_MESSAGE");
        TextView display2 = (TextView) findViewById(R.id.info);
        display2.setText(details);

        completed = intent.getStringExtra("IS_COMPLETE");
        TextView display3 = (TextView) findViewById(R.id.complete);
        display3.setText(completed);

        ImageButton button = (ImageButton) findViewById(R.id.task_completed);
        if (completed.equals("TASK INCOMPLETE")) {
            button.setImageResource(R.drawable.box);
        }
        else {
            if (position == 0 || position == 11) {
                button.setImageResource(R.drawable.brittnay); //Changes the button to purple thing
            }
            if (position == 1 || position == 12) {
                button.setImageResource(R.drawable.deandra);
            }
            if (position == 2 || position == 13) {
                button.setImageResource(R.drawable.jenna);
            }
            if (position == 3 || position == 14) {
                button.setImageResource(R.drawable.mckenzie);
            }
            if (position == 4 || position == 15) {
                button.setImageResource(R.drawable.rachel);
            }
            if (position == 5 || position == 16) {
                button.setImageResource(R.drawable.shay);
            }
            if (position == 6 || position == 17 || position == 10) {
                button.setImageResource(R.drawable.taylor);
            }
            if (position == 7 || position == 18) {
                button.setImageResource(R.drawable.trisha);
            }
            if (position == 8 || position == 19) {
                button.setImageResource(R.drawable.trisha2);
            }
            if (position == 9 || position == 20) {
                button.setImageResource(R.drawable.saison);
            }
        }

        position = intent.getIntExtra("POSITION", 0);
        Toast.makeText(this, String.valueOf(position), Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onResume() {
        super.onResume();

//        int width = dm.widthPixels;
//        int height = dm.heightPixels;
//        getWindow().setLayout((int)(width*1.0), (int)(height*1.0));
    }
    public void setCompleteStatus(View view) {
        ImageButton button = (ImageButton) view.findViewById(R.id.task_completed);

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        Intent intent = new Intent(this, MainActivity.class);
        int isDone = settings.getInt(String.valueOf(position), 0);
        TextView text = (TextView) findViewById(R.id.complete);
        if (isDone == 0) {

            text.setText("TASK COMPLETE! CONGRATULATIONS!");
            editor.putInt(String.valueOf(String.valueOf(position)), 1);
            if (position == 0 || position == 11) {
                button.setImageResource(R.drawable.brittnay); //Changes the button to purple thing
            }
            if (position == 1 || position == 12) {
                button.setImageResource(R.drawable.deandra);
            }
            if (position == 2 || position == 13) {
                button.setImageResource(R.drawable.jenna);
            }
            if (position == 3 || position == 14) {
                button.setImageResource(R.drawable.mckenzie);
            }
            if (position == 4 || position == 15) {
                button.setImageResource(R.drawable.rachel);
            }
            if (position == 5 || position == 16) {
                button.setImageResource(R.drawable.shay);
            }
            if (position == 6 || position == 17 || position == 10) {
                button.setImageResource(R.drawable.taylor);
            }
            if (position == 7 || position == 18) {
                button.setImageResource(R.drawable.trisha);
            }
            if (position == 8 || position == 19) {
                button.setImageResource(R.drawable.trisha2);
            }
            if (position == 9 || position == 20) {
                button.setImageResource(R.drawable.saison);
            }
        }
        else {
            text.setText("TASK INCOMPLETE");
            button.setImageResource(R.drawable.box);
            number = 0;
            editor.putInt(String.valueOf(String.valueOf(position)), 0);

        }
        intent.putExtra("COMPLETED", number);
        intent.putExtra("POSITION", position);
        editor.commit();
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent a = new Intent(this, MainActivity.class);
            a.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(a);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    public void saveEntry(View view) {
        Intent a = new Intent(this, MainActivity.class);
        a.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(a);
    }
}
