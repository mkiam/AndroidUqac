package com.example.user.myapplication;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by User on 23/03/2016.
 */
public class UserDAO extends DAOBase{
    public static final String TABLE_NAME = "User";
    public static final String KEY = "id";
    public static final String NAME = "nom";
    public static final String NICKNAME = "pseudo";
    public static final String EMAIL = "adresse";
    public static final String PASSWORD= "mdp";


    public static final String TABLE_CREATE = "CREATE TABLE " + TABLE_NAME + " (" +
            KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            NAME + " TEXT, " +
            NICKNAME + " TEXT, " +
            EMAIL + " TEXT, " +
            PASSWORD+ " TEXT);";

    public static final String TABLE_DROP =  "DROP TABLE IF EXISTS " + TABLE_NAME + ";";

    /**
     * @param u l'utilisateur à ajouter à la base
     */
    public void add(User u) {

        ContentValues value = new ContentValues();
        value.put(UserDAO.NAME, u.getName());
        value.put(UserDAO.NICKNAME, u.getNickname());
        value.put(UserDAO.EMAIL, u.getEmail());
        value.put(UserDAO.PASSWORD, u.getPassword());
        mDb.insert(UserDAO.TABLE_NAME, null, value);

    }

    /**
     * @param id l'identifiant de l'utilisateur à supprimer
     */
    public void remove(long id) {
        mDb.delete(TABLE_NAME, KEY + " = ?", new String[] {String.valueOf(id)});
    }

    /**
     * @param u l'utilisateur modifié
     */
    public void update(User u) {
        // CODE
    }

    /**
     * @param nickname l'identifiant du métier à récupérer
     */
    public boolean getUser(String nickname, String password) {
        Cursor c = mDb.rawQuery("SELECT NAME, FROM " +
                TABLE_NAME +" WHERE NICKNAME = ? AND PASSWORD = ?", new String[] {nickname, password});
        if (c.moveToNext()) {
            return true;

        }
        return false;
   }
}



