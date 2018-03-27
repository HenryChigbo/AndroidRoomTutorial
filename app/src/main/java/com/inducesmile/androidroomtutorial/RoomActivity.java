package com.inducesmile.androidroomtutorial;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.inducesmile.androidroomtutorial.adapter.RoomAdapter;
import com.inducesmile.androidroomtutorial.database.AppDatabase;
import com.inducesmile.androidroomtutorial.database.Message;
import com.inducesmile.androidroomtutorial.database.MessageDao;
import com.inducesmile.androidroomtutorial.utils.MessageDialog;

import java.util.List;

public class RoomActivity extends AppCompatActivity {

    private final String TAG = RoomActivity.class.getSimpleName();

    private RoomAdapter roomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.messages);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(RoomActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        MessageDao messageDao = (MessageDao) AppDatabase.getInstance(getApplicationContext()).message();
        messageDao.getAllMessage().observe(this, (List<Message> message) -> {
            roomAdapter = new RoomAdapter(RoomActivity.this, message);
            recyclerView.setAdapter(roomAdapter);
        });


        ImageView addMessageBtn = (ImageView) findViewById(R.id.add_btn);
        addMessageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MessageDialog dialog = new MessageDialog(RoomActivity.this);
                dialog.addNewMessage(R.layout.dialog_layout);
            }
        });
    }
}
