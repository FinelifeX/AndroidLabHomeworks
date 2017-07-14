package com.example.user.profilehomework;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    public static final String KEY_USER = "user";
    public static final int CAMERA_REQUEST = 1;
    public static final int CAMERA_PERMISSION_CODE = 2;

    ImageView userPhoto;
    EditText userName;
    EditText userName2;
    EditText userNumber;
    User user;
    SharedPreferences sharedPreferences;
    long currentTime = System.currentTimeMillis();

    Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getPreferences(MODE_PRIVATE);

        final String[] permissions = {Manifest.permission.CAMERA};

        userPhoto = (ImageView) findViewById(R.id.photo);
        userName = (EditText) findViewById(R.id.username);
        userName2 = (EditText) findViewById(R.id.username2);
        userNumber = (EditText) findViewById(R.id.usernumber);

        user = createUserProfile();

        if(currentTime - user.getLastVisit() >= 60000) {
            userName.setText("");
            userName2.setText("");
            userNumber.setText("");
        }
        else {
            userName.setText(user.getName());
            userName2.setText(user.getName2());
            userNumber.setText(user.getNumber());
        }

        userPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA)
                        != PackageManager.PERMISSION_GRANTED) {
                    if (ActivityCompat.shouldShowRequestPermissionRationale
                            (MainActivity.this, Manifest.permission.CAMERA)) {
                        Toast.makeText(getApplicationContext(), "Turn on camera permission!", Toast.LENGTH_SHORT).show();
                    } else {
                        ActivityCompat.requestPermissions(MainActivity.this, permissions, CAMERA_PERMISSION_CODE);
                    }
                } else {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent, CAMERA_REQUEST);
                }

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {
            Bitmap userPhoto = (Bitmap) data.getExtras().get("data");
            this.userPhoto.setImageBitmap(userPhoto);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        String json = gson.toJson(new User(userName.getText().toString(), userName2.getText().toString(),
                userNumber.getText().toString(), System.currentTimeMillis()));
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_USER, json);
        editor.apply();
    }

    protected User createUserProfile() {
        String json = sharedPreferences.getString(KEY_USER, "{}");
        return gson.fromJson(json, User.class);
    }
}
