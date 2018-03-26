package com.inducesmile.androidroomtutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class RoomActivity extends AppCompatActivity {

    private final String TAG = RoomActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
    }
}
