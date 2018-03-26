package com.inducesmile.androidroomtutorial.database;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface MessageDao {


    @Query("")
    public List<Message> getAllMessage();


    @Delete
    public void deleteMessage();


    @Insert
    public void insertNewMessage();

}
