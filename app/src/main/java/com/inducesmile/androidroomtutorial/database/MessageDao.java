package com.inducesmile.androidroomtutorial.database;


import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface MessageDao {

    @Query("Select * from Message")
    public LiveData<List<Message>> getAllMessage();


    @Delete
    public void deleteMessage(Message message);


    @Insert(onConflict = REPLACE)
    public void insertNewMessage(Message message);

}
