/*
 * Copyright 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.borderlessbuttons;

import android.app.ListActivity;
import android.content.ActivityNotFoundException;
import android.content.ContentProviderOperation;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This activity demonstrates the <b>borderless button</b> styling from the Holo visual language.
 * The most interesting bits in this sample are in the layout files (res/layout/).
 * <p>
 * See <a href="http://developer.android.com/design/building-blocks/buttons.html#borderless">
 * borderless buttons</a> at the Android Design guide for a discussion of this visual style.
 */
public class MainActivity extends ListActivity {
    MediaPlayer excuse_me, free_hips, poop_here;

    public final static String EXTRA_MESSAGE = "Hello.";
    public static final String PREFS_NAME = "PrefsFile";
    private static final Uri DOCS_URI = Uri.parse(
            "http://developer.android.com/design/building-blocks/buttons.html#borderless");

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample_main);

        setListAdapter(mListAdapter);

        findViewById(R.id.cancel_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        findViewById(R.id.ok_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //Instantiating music
        excuse_me = MediaPlayer.create(this, R.raw.excuse_me);
        free_hips = MediaPlayer.create(this, R.raw.free_hips);
        poop_here = MediaPlayer.create(this, R.raw.poop_here);
    }

    private BaseAdapter mListAdapter = new BaseAdapter() {
        @Override
        public int getCount() {
            return 20;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position + 1;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup container) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.list_item, container, false);
            }

            //Restoring saved data
            SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
            String key = String.valueOf(position);
            int isDone = settings.getInt(key, 0);
            ImageButton button = (ImageButton) convertView.findViewById(R.id.secondary_action);
            if (isDone == 0) {
                button.setImageResource(R.drawable.box);
            }
            else if (isDone == 1) {
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




            //Setting the tasks
            TextView text = (TextView) convertView.findViewById(R.id.text1);

            if (position == 0) {
                text.setText("Streak the lawn");

            }
            if (position == 1) {
                text.setText("Get so drunk that you vomit.");
            }
            if (position == 2) {
                text.setText("Poop in a public restroom.");
            }
            if (position == 3) {
                text.setText("Do heroine with friends in a Satanist potluck.");
            }
            if (position == 4) {
                text.setText("Give the nerds wedgies");
            }
            if (position == 5) {
                text.setText("Sacrifice a sratstar");
            }
            if (position == 6) {
                text.setText("Go to the homecoming game");
            }
            if (position == 7) {
                text.setText("Eat at the dumpling truck");
            }
            if (position == 8) {
                text.setText("Complain about the food");
            }
            if (position == 9) {
                text.setText("Get food poisoning at the dining halls");
            }
            if (position == 10) {
                text.setText("Pull an all nighter in Clemons");
            }
            if (position == 11) {
                text.setText("Give a hug to Ms.Kathy");
            }
            if (position == 12) {
                text.setText("Pull an all nighter in Clemons");
            }
            if (position == 13) {
                text.setText("Dance at Trinity");
            }
            if (position == 14) {
                text.setText("Go hiking somewhere");
            }
            if (position == 15) {
                text.setText("Handshake with Dean Groves");
            }
            if (position == 16) {
                text.setText("Find a steam tunnel");
            }
            if (position == 17) {
                text.setText("Get an A in a class");
            }
            if (position == 18) {
                text.setText("Build a snowman on the lawn");
            }
            if (position == 19) {
                text.setText("Befriend a grad student");
            }
            if (position == 20) {
                text.setText("Have lunch with a professor");
            }
            // Because the list item contains multiple touch targets, you should not override
            // onListItemClick. Instead, set a click listener for each target individually.
            final Intent intent = new Intent(MainActivity.this, Info.class);
            final TextView editText = (TextView) convertView.findViewById(R.id.text1); //instead of R.id.text1?
            final TextView information = (TextView) convertView.findViewById(R.id.text2);

            convertView.findViewById(R.id.primary_target).setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            /**
                            Toast.makeText(MainActivity.this,
                                    "Touched this noise. " + R.id.primary_target,
                                    Toast.LENGTH_SHORT).show();

                             * Here I think that we can start the new Activity. Somehow.
*/
                            //Description
                            String message = editText.getText().toString();
                            //Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                            intent.putExtra("RESULT_MESSAGE", message);

                            //Details
                            String details = information.getText().toString();
                            intent.putExtra("INFO_MESSAGE", details);

                            //Whether the task is complete or incomplete
                            String iscomplete = "TASK INCOMPLETE";
                            SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
                            String key = String.valueOf(position);
                            int isDone = settings.getInt(key, 0);
                            if (isDone == 1) {
                                iscomplete = "TASK COMPLETE";
                            }
                            intent.putExtra("IS_COMPLETE", iscomplete);

                            //The position so we know which image to use
                            intent.putExtra("POSITION", position);

                            startActivity(intent);
                        }
                    });
            convertView.findViewById(R.id.secondary_action).setOnClickListener(
                    new View.OnClickListener() {
                        int number = 0;
                        @Override
                        public void onClick(View view) {
                            //Toast.makeText(MainActivity.this,
                             //       R.string.touched_secondary_message,
                             //       Toast.LENGTH_SHORT).show();

                            boolean done;
                            number++;
                            ImageButton btn = (ImageButton)view;
                            SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
                            SharedPreferences.Editor editor = settings.edit();

                            if (number % 2 == 1) {
                                if (position == 0 || position == 11) {
                                    btn.setImageResource(R.drawable.brittnay); //Changes the button to purple thing
                                    editor.putInt(String.valueOf(position), 1);
                                    excuse_me.start();
                                    excuse_me.setLooping(false);
                                }
                                if (position == 1 || position == 12) {
                                    btn.setImageResource(R.drawable.deandra);
                                    editor.putInt(String.valueOf(position), 1);
                                }
                                if (position == 2 || position == 13) {
                                    btn.setImageResource(R.drawable.jenna);
                                    editor.putInt(String.valueOf(position), 1);
                                }
                                if (position == 3 || position == 14) {
                                    btn.setImageResource(R.drawable.mckenzie);
                                    editor.putInt(String.valueOf(position), 1);
                                }
                                if (position == 4 || position == 15) {
                                    btn.setImageResource(R.drawable.rachel);
                                    editor.putInt(String.valueOf(position), 1);
                                }
                                if (position == 5 || position == 16) {
                                    btn.setImageResource(R.drawable.shay);
                                    editor.putInt(String.valueOf(position), 1);
                                }
                                if (position == 6 || position == 17 || position == 10) {
                                    btn.setImageResource(R.drawable.taylor);
                                    editor.putInt(String.valueOf(position), 1);
                                }
                                if (position == 7 || position == 18) {
                                    btn.setImageResource(R.drawable.trisha);
                                    editor.putInt(String.valueOf(position), 1);
                                }
                                if (position == 8 || position == 19) {
                                    btn.setImageResource(R.drawable.trisha2);
                                    editor.putInt(String.valueOf(position), 1);
                                }
                                if (position == 9 || position == 20) {
                                    btn.setImageResource(R.drawable.saison);
                                    editor.putInt(String.valueOf(position), 1);
                                }
                            }
                            else{
                                btn.setImageResource(R.drawable.box);
                                number = 0;
                                editor.putInt(String.valueOf(position), 0);
                            }
                            editor.commit();
                        }
                    });
            return convertView;
        }
        //These two methods disable RecycleView, I think...
        @Override
        public int getViewTypeCount() {
            return getCount();
        }
        @Override
        public int getItemViewType(int position) {
            return position;
        }

    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.docs_link:
                try {
                    //startActivity(new Intent(Intent.ACTION_VIEW, DOCS_URI));
                    startActivity(new Intent(this, Description.class));
                } catch (ActivityNotFoundException ignored) {
                }
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onPause() {
        super.onPause();
    }
}
