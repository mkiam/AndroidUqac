package com.example.user.myapplication;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by User on 23/03/2016.
 */
public class DatabaseHandler extends SQLiteOpenHelper {
    public static final String USER_KEY = "id";
    public static final String NAME = "nom";
    public static final String NICKNAME = "pseudo";
    public static final String EMAIL = "adresse";
    public static final String PASSWORD= "mdp";

    public static final String USER_TABLE_NAME = "User";
    public static final String USER_TABLE_CREATE =
            "CREATE TABLE " + USER_TABLE_NAME + " (" +
                    USER_KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    NAME + " TEXT, " +
                    NICKNAME + " TEXT, " +
                    EMAIL + " TEXT, " +
                    PASSWORD+ " TEXT);";

    public DatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(USER_TABLE_CREATE);
    }
    public static final String USER_TABLE_DROP = "DROP TABLE IF EXISTS " + USER_TABLE_NAME + ";";

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(USER_TABLE_DROP);
        onCreate(db);
    }

}

