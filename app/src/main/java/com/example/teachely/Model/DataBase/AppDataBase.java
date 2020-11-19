package com.example.teachely.Model.DataBase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.teachely.Model.Model.Student;

@Database(version = 1,exportSchema = false,entities = {Student.class})
public abstract class AppDataBase extends RoomDatabase {
    private static AppDataBase appDataBase;

    public static AppDataBase getAppDataBase(Context context){
        if (appDataBase== null){
            appDataBase= Room.databaseBuilder(context.getApplicationContext(),AppDataBase.class,"db_teachly_app")
                    .allowMainThreadQueries()
                    .build();
        }
        return appDataBase;
    }

    public abstract StudentDao getStudentDao();
}
