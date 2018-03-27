package com.inducesmile.androidroomtutorial.utils;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.inducesmile.androidroomtutorial.R;
import com.inducesmile.androidroomtutorial.database.AppDatabase;
import com.inducesmile.androidroomtutorial.database.Message;
import com.inducesmile.androidroomtutorial.database.MessageDao;

public class MessageDialog {

    private Context context;

    public MessageDialog(Context context) {
        this.context = context;
    }

    public void addNewMessage(int dialog_layout){
        LayoutInflater inflater = LayoutInflater.from(context);
        View subView = inflater.inflate(dialog_layout, null);

        final EditText nameField = (EditText)subView.findViewById(R.id.enter_message);

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Add new message");
        builder.setView(subView);
        builder.create();
        builder.setPositiveButton("ADD MESSAGE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                final String message = nameField.getText().toString();
                if(TextUtils.isEmpty(message)){
                    Toast.makeText(context, "Empty or invalid input", Toast.LENGTH_LONG).show();
                }
                else{
                    Message content = new Message(message);
                    //add new message to database
                    MessageDao messageDao = (MessageDao) AppDatabase.getInstance(context).message();
                    messageDao.insertNewMessage(content);
                }
            }
        });
        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, "Task cancelled", Toast.LENGTH_LONG).show();
            }
        });
        builder.show();
    }
}
