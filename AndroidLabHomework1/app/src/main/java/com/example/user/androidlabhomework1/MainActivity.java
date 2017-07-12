package com.example.user.androidlabhomework1;

import android.app.ActionBar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = (TextView) findViewById(R.id.textView);
        textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        textView.setTextSize(50);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), textView.getText(), Toast.LENGTH_LONG);
                toast.setGravity(Gravity.TOP, 0, 0);
                toast.show();
            }
        });

        LinearLayout linearLayout;
        int con = 1;
        for(int i = 0; i < 3; i++) {
            if(i == 0) {
                linearLayout = (LinearLayout) findViewById(R.id.linear1);
            }
            else if(i == 1) {
                linearLayout = (LinearLayout) findViewById(R.id.linear2);
            }
            else {
                linearLayout = (LinearLayout) findViewById(R.id.linear3);
            }
            for (int j = 0; j < 3; j++) {
                Button btn = new Button(this);
                btn.setId(i + j + con);
                final String buttonText = btn.getId() + "";
                btn.setText(buttonText);
                btn.setLayoutParams(new LinearLayout.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT, 1f));
                linearLayout.addView(btn);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        textView.setText(textView.getText() + buttonText);
                    }
                });

            }
            con += 2;
        }

        linearLayout = (LinearLayout) findViewById(R.id.linear4);
        linearLayout.setGravity(View.TEXT_ALIGNMENT_CENTER);

        Button btn = new Button(this);
        btn.setLayoutParams(new LinearLayout.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT, 1f));
        btn.setText("Enter");
        linearLayout.addView(btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), textView.getText(), Toast.LENGTH_LONG);
                toast.setGravity(Gravity.TOP, 0, 0);
                toast.show();
                textView.setText("");
            }
        });

        btn = new Button(this);
        btn.setLayoutParams(new LinearLayout.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT, 1f));
        btn.setId(0);
        btn.setText(0 + "");
        final String buttonText = "0";
        linearLayout.addView(btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText() + buttonText);
            }
        });

        btn = new Button(this);
        btn.setLayoutParams(new LinearLayout.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT, 1f));
        btn.setText("Delete");
        linearLayout.addView(btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textView.getText().length() > 0) {
                    textView.setText(textView.getText().subSequence(0, textView.getText().length() - 1));
                }
            }
        });
    }
}
