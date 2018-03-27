package com.inducesmile.androidroomtutorial.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.inducesmile.androidroomtutorial.R;

public class RoomViewHolder extends RecyclerView.ViewHolder{

    public TextView content;
    public TextView contentDate;
    public ImageView contentDelete;

    public RoomViewHolder(View itemView) {
        super(itemView);

        content = (TextView)itemView.findViewById(R.id.content);
        contentDate = (TextView)itemView.findViewById(R.id.content_date);
        contentDelete = (ImageView)itemView.findViewById(R.id.content_delete);
    }
}
