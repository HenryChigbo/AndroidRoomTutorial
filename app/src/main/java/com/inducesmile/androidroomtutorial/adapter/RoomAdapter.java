package com.inducesmile.androidroomtutorial.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.inducesmile.androidroomtutorial.R;
import com.inducesmile.androidroomtutorial.database.Message;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Date;
import java.util.List;

public class RoomAdapter extends RecyclerView.Adapter<RoomViewHolder> {

    private List<Message> messageList;
    private Context context;

    public RoomAdapter(Context context, List<Message> messageList) {
        this.messageList = messageList;
        this.context = context;
    }

    @Override
    public RoomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_layout, parent, false);
        return new RoomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RoomViewHolder holder, int position) {
        Message message = messageList.get(position);

        String currentDate = getCurrentDateTime();

        holder.content.setText(message.getContent());
        holder.contentDate.setText(currentDate);

        holder.contentDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // add a code that can delete a message
                // item when the delete icon is clicked
            }
        });
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }

    private String getCurrentDateTime(){
        Date currentDate = new Date();
        DateTime dt = new DateTime(currentDate);
        DateTimeFormatter fmt = DateTimeFormat.forPattern("MM/dd/YYYY");
        String strDateOnly = fmt.print(dt);
        return strDateOnly;
    }
}
