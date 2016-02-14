package com.example.android.borderlessbuttons;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;

public class NewTask extends Activity {
    public static final String PREFS_NAME = "PrefsFile";
    public static final String PREFS_TASK = "TasksFile";
    public static final String PREFS_DESCRIPTION = "Description";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);
    }
    public void addNewTask(View view) {
        Intent a = new Intent(this, MainActivity.class);
        EditText newTask = (EditText) findViewById(R.id.editText);
        String newTaskString = newTask.getText().toString();
        EditText newDetails = (EditText) findViewById(R.id.editText2);
        String newDetailsString = newDetails.getText().toString();
        a.putExtra("NEW_TASK", newTaskString);
        a.putExtra("NEW_DETAILS", newDetailsString);

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("Count", settings.getInt("Count", 20) + 1);

        SharedPreferences tasks = getSharedPreferences(PREFS_TASK, 0);
        SharedPreferences.Editor editor_tasks = tasks.edit();
        editor_tasks.putString(String.valueOf(settings.getInt("Count", 20)), newTaskString);

        SharedPreferences description = getSharedPreferences(PREFS_DESCRIPTION, 0);
        SharedPreferences.Editor editor_description = description.edit();
        editor_description.putString(String.valueOf(settings.getInt("Count", 20)), newDetailsString);

        editor.commit();
        editor_tasks.commit();
        editor_description.commit();


        a.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(a);
    }
}
