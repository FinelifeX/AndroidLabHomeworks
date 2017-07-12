package com.example.user.androidlablesson2cookbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FullRecipeActivity extends AppCompatActivity {

    public static final String DATA = "full data";

    String [] data;
    TextView name;
    TextView time;
    TextView difficulty;
    TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_recipe);

        data = getIntent().getStringArrayExtra(DATA);

        name = (TextView) findViewById(R.id.name);
        time = (TextView) findViewById(R.id.time);
        difficulty = (TextView) findViewById(R.id.difficulty);
        description = (TextView) findViewById(R.id.description);

        name.setText(data[0]);
        time.setText(data[1]);
        difficulty.setText(data[2]);
        description.setText(data[3]);
    }
}
