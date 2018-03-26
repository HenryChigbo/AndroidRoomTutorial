package com.inducesmile.androidroomtutorial.database;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.content.Context;

@Database(entities = {Message.class}, version = 1)
public abstract class AppDatabase {

    private static AppDatabase appDatabase;

    abstract Message message();

    private Context context;


    public static AppDatabase getInstance(Context context){

        if(appDatabase == null){
            appDatabase = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "Message-database")
                    .allowMainThreadQueries()
                    .build();
        }
    }


}
