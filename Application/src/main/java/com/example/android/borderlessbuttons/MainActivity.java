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
    MediaPlayer excuse_me, free_hips, poop_here, enough, satan, Tania_laugh, mall, yeah;
    public final static String EXTRA_MESSAGE = "Hello.";
    public static final String PREFS_NAME = "PrefsFile";
    public static final String PREFS_COUNT = "PrefsCount";
    private static final Uri DOCS_URI = Uri.parse(
            "http://developer.android.com/design/building-blocks/buttons.html#borderless");
    private int completed;
    private int positionAltered;
    public static final String PREFS_TASK = "TasksFile";
    public static final String PREFS_DESCRIPTION = "Description";
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

        Intent intent = getIntent();
        completed = intent.getIntExtra("COMPLETED", 0);

        positionAltered = intent.getIntExtra("POSITION", 500);

        //Instantiating music
        excuse_me = MediaPlayer.create(this, R.raw.excuse_me);
        free_hips = MediaPlayer.create(this, R.raw.free_hips);
        poop_here = MediaPlayer.create(this, R.raw.poop_here);
        Tania_laugh = MediaPlayer.create(this, R.raw.tania_laugh);
        yeah = MediaPlayer.create(this, R.raw.yeah);
        satan = MediaPlayer.create(this, R.raw.satan);
        enough = MediaPlayer.create(this, R.raw.enough);
        mall = MediaPlayer.create(this, R.raw.mall);
    }

    private BaseAdapter mListAdapter = new BaseAdapter() {
        @Override
        public int getCount() {

            SharedPreferences countSettings = getSharedPreferences(PREFS_NAME, 0);
            int editCountValue = countSettings.getInt("Count", 20);
            return editCountValue;
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
            TextView text = (TextView) convertView.findViewById(R.id.text1);
            TextView desc = (TextView) convertView.findViewById(R.id.text2);
            if (position == 0) {
                text.setText("Streak the lawn");
                desc.setText("Everybody knows that as a student, it’s a tradition to shake what your mother " +
                        "gave you across the sacred grounds of the lawn. Let Thomas Jefferson know that you " +
                        "go here by showing off the unholy to the holy.");
            }
            if (position == 1) {
                text.setText("Get so drunk that you vomit.");
                desc.setText("Partying so hard that you lose control of yourself is so hip. What other way to show" +
                        " that by giving what you got? Disclaimer: If you don’t drink, then you’re a square. However, " +
                        "not all hope is lost. You can fake it till you make it.”");
            }
            if (position == 2) {
                text.setText("Poop in a public restroom.");
                desc.setText("You know that you’re not going to be home all the time. And nature calls whenever " +
                        "you’re not ready. Brace for it by heading to your local library’s bathroom.");
            }
            if (position == 3) {
                text.setText("Do heroine with friends in a Satanist potluck.");
                desc.setText("What are you doing if you’re not trying new things? This is college!! Have some fun!!" +
                        "Sacrifice a baby!");
            }
            if (position == 4) {
                text.setText("Give the nerds wedgies");
                desc.setText("In this world; it’s bully or get bullied. The corporate world will be your prime example" +
                        " if you’re not ready. If you’re a ‘’nerd’’ do yourself a solid.");
            }
            if (position == 5) {
                text.setText("Sacrifice a sratstar");
                desc.setText("’Sacrifice’ is up for interpretation, based on how you feel fit. Don’t sue me if you " +
                        "break the law");
            }
            if (position == 6) {
                text.setText("Go to the homecoming game");
                desc.setText("Yay, football! Yay, cute boys/butts!!! You can tell which team I'm on!");
            }
            if (position == 7) {
                text.setText("Eat at the dumpling truck");
                desc.setText("Pie guy, who?”");
            }
            if (position == 8) {
                text.setText("Complain about the food");
                desc.setText("This applies to dining hall. Choose one, several, or all the choice is up to you." +
                        "Pick your poison.");
            }
            if (position == 9) {
                text.setText("Get food poisoning at the dining halls");
                desc.setText("Never forget O'bola 2k14. Many bladders fell victim.");
            }
            if (position == 10) {
                text.setText("Pull an all nighter in Clemons");
                desc.setText("It doesn’t have to be for class. You could be marathoning Barney the Dinosaur, for all I care.");
            }
            if (position == 11) {
                text.setText("Give a hug to Ms. Kathy");
                desc.setText("A true cinnamon roll. So good. So pure.");
            }
            if (position == 12) {
                text.setText("Go to all four gyms");
                desc.setText("Then you've worked out at least four times!");
            }
            if (position == 13) {
                text.setText("Dance at Trinity");
                desc.setText("So the other people will have something to laugh at. Nerd.");
            }
            if (position == 14) {
                text.setText("Go hiking somewhere");
                desc.setText("Preferably a place far away. Like the alps! Go away and save other students the displeasure" +
                        "of your presence.");
            }
            if (position == 15) {
                text.setText("Handshake with Dean Groves");
                desc.setText("Another cinnamon roll. I hear that if you look into his eyes, you will be cleansed of your sins," +
                        " gross sins you’ve done.");
            }
            if (position == 16) {
                text.setText("Find a steam tunnel");
                desc.setText("But don’t enter it! Because that’s illegal and I don’t condone breaking the law. *winks*");
            }
            if (position == 17) {
                text.setText("Get an A in a class");
                desc.setText("This is for your own good.");
            }
            if (position == 18) {
                text.setText("Build a snowman on the lawn");
                desc.setText("It's the closest thing to a friend you will ever have.");
            }
            if (position == 19) {
                text.setText("Befriend a grad student");
                desc.setText("You know there's a whole bunch of them on Grindr. *winks*");
            }
            for (int i = 20; i < getCount(); i++)
            {
                if (position == i) {
                    SharedPreferences task = getSharedPreferences(PREFS_TASK, 0);
                    SharedPreferences description = getSharedPreferences(PREFS_DESCRIPTION, 0);

                    text.setText(task.getString(String.valueOf(position), "Dummy title"));
                    desc.setText(description.getString(String.valueOf(position), "Dummy description"));
                }
            }
                //Restoring saved data
            SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
//            SharedPreferences.Editor editor = settings.edit();
            String key = String.valueOf(position);
            int isDone = settings.getInt(key, 0);
            ImageButton btn = (ImageButton) convertView.findViewById(R.id.secondary_action);
            if (isDone == 0) {
                btn.setImageResource(R.drawable.box);
            } else if (isDone == 1) {
                if (position == 0 || position == 11) {
                    btn.setImageResource(R.drawable.brittnay); //Changes the button to purple thing
                }
                if (position == 1 || position == 12) {
                    btn.setImageResource(R.drawable.deandra);
                }
                if (position == 2 || position == 13) {
                    btn.setImageResource(R.drawable.jenna);
                }
                if (position == 3 || position == 14) {
                    btn.setImageResource(R.drawable.mckenzie);
                }
                if (position == 4 || position == 15) {
                    btn.setImageResource(R.drawable.rachel);
                }
                if (position == 5 || position == 16) {
                    btn.setImageResource(R.drawable.shay);
                }
                if (position == 6 || position == 17 || position == 10) {
                    btn.setImageResource(R.drawable.taylor);
                }
                if (position == 7 || position == 18) {
                    btn.setImageResource(R.drawable.trisha);
                }
                if (position == 8 || position == 19) {
                    btn.setImageResource(R.drawable.trisha2);

                }
                if (position == 9 || position == 20) {
                    btn.setImageResource(R.drawable.saison);
                }
                if (position > 20) {
                    if (position % 2 == 0)
                        btn.setImageResource(R.drawable.matt);
                    if (position % 2 == 1)
                        btn.setImageResource(R.drawable.belinda);
                }
            }
/*

//                if(position == positionAltered) {
//                    if (completed == 1) {
//                        button.setImageResource(R.drawable.saison);
//                    }
//                    if (completed == 0) {
//                        button.setImageResource(R.drawable.trisha2);
//                    }
//                }
                }
*/
            //Setting the tasks

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
                            ImageButton btn = (ImageButton) view;
                            SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
                            SharedPreferences.Editor editor = settings.edit();
                            int isDone = settings.getInt(String.valueOf(position), 0);
                            if (isDone == 0) {
                                number = 1;
                                if (position == 0 || position == 11) {
                                    btn.setImageResource(R.drawable.brittnay); //Changes the button to purple thing
                                    editor.putInt(String.valueOf(position), 1);
                                    //excuse_me.start();
                                    //excuse_me.setLooping(false);
                                    editor.putInt(String.valueOf(position), 1);
                                    if (position == 0) {
                                        free_hips.start();
                                        free_hips.setLooping(false);
                                    } else if (position == 11) {
                                        yeah.start();
                                        yeah.setLooping(false);
                                    }
                                }
                                if (position == 1 || position == 12) {
                                    btn.setImageResource(R.drawable.deandra);
                                    editor.putInt(String.valueOf(position), 1);
                                    if (position == 1) {
                                        Tania_laugh.start();
                                        Tania_laugh.setLooping(false);
                                    } else if (position == 12) {
                                        satan.start();
                                        satan.setLooping(false);
                                    }
                                }
                                if (position == 2 || position == 13) {
                                    btn.setImageResource(R.drawable.jenna);
                                    editor.putInt(String.valueOf(position), 1);
                                    if (position == 2) {
                                        poop_here.start();
                                        poop_here.setLooping(false);
                                    } else if (position == 13) {
                                        yeah.start();
                                        yeah.setLooping(false);
                                    }
                                }
                                if (position == 3 || position == 14) {
                                    btn.setImageResource(R.drawable.mckenzie);
                                    editor.putInt(String.valueOf(position), 1);
                                    if (position == 3) {
                                        satan.start();
                                        satan.setLooping(false);
                                    } else if (position == 14) {
                                        mall.start();
                                        mall.setLooping(false);
                                    }
                                }
                                if (position == 4 || position == 15) {
                                    btn.setImageResource(R.drawable.rachel);
                                    editor.putInt(String.valueOf(position), 1);
                                    if (position == 4) {
                                        free_hips.start();
                                        free_hips.setLooping(false);
                                    } else if (position == 15) {
                                        yeah.start();
                                        yeah.setLooping(false);
                                    }
                                }
                                if (position == 5 || position == 16) {
                                    btn.setImageResource(R.drawable.shay);
                                    editor.putInt(String.valueOf(position), 1);
                                    if (position == 5) {
                                        enough.start();
                                        enough.setLooping(false);
                                    } else if (position == 16) {
                                        Tania_laugh.start();
                                        Tania_laugh.setLooping(false);
                                    }
                                }
                                if (position == 6 || position == 17 || position == 10) {
                                    btn.setImageResource(R.drawable.taylor);
                                    editor.putInt(String.valueOf(position), 1);
                                    if (position == 6) {
                                        Tania_laugh.start();
                                        Tania_laugh.setLooping(false);
                                    } else if (position == 17) {
                                        yeah.start();
                                        yeah.setLooping(false);
                                    } else if (position == 10) {
                                        satan.start();
                                        satan.setLooping(false);
                                    }
                                }
                                if (position == 7 || position == 18) {
                                    btn.setImageResource(R.drawable.trisha);
                                    editor.putInt(String.valueOf(position), 1);
                                    if (position == 1) {
                                        yeah.start();
                                        yeah.setLooping(false);
                                    } else if (position == 18) {
                                        Tania_laugh.start();
                                        Tania_laugh.setLooping(false);
                                    }
                                }
                                if (position == 8 || position == 19) {
                                    btn.setImageResource(R.drawable.trisha2);
                                    editor.putInt(String.valueOf(position), 1);
                                    if (position == 8) {
                                        excuse_me.start();
                                        excuse_me.setLooping(false);
                                    } else if (position == 19) {
                                        yeah.start();
                                        yeah.setLooping(false);
                                    }
                                }
                                if (position == 9 || position == 20) {
                                    btn.setImageResource(R.drawable.saison);
                                    editor.putInt(String.valueOf(position), 1);
                                    if (position == 9) {
                                        poop_here.start();
                                        poop_here.setLooping(false);
                                    } else if (position == 20) {
                                        Tania_laugh.start();
                                        Tania_laugh.setLooping(false);
                                    }
                                }
                                if (position > 20) {
                                    btn.setImageResource(R.drawable.matt);
                                    editor.putInt(String.valueOf(position), 1);
                                }

                            } else {
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
    public void addNewTask(View view) {
        Intent intent = new Intent(this, NewTask.class);
        startActivity(intent);
    }
}
