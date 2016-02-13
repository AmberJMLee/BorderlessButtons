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
    public final static String EXTRA_MESSAGE = "Hello.";

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
    }

    private BaseAdapter mListAdapter = new BaseAdapter() {
        @Override
        public int getCount() {
            return 10;
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
        public View getView(int position, View convertView, ViewGroup container) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.list_item, container, false);
            }
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
            // Because the list item contains multiple touch targets, you should not override
            // onListItemClick. Instead, set a click listener for each target individually.

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
                            Intent intent = new Intent(MainActivity.this, Info.class);
                            TextView editText = (TextView) findViewById(R.id.text1); //instead of R.id.text1?
                            String message = editText.getText().toString();
                            intent.putExtra("title", message);
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

                            if (number % 2 == 1) {
                                done = true;
                                btn.setImageResource(R.drawable.ic_launcher); //Changes the button to purple thing
                            }
                            else{
                                done = false;
                                btn.setImageResource(R.drawable.box);
                                number = 0;
                            }
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
}
