package com.example.alertika.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.alertika.data.ContactsContract.ContactEntry;
public class EmergencyContactsDbHelper extends SQLiteOpenHelper {

    public static final String LOG_TAG  = EmergencyContactsDbHelper.class.getSimpleName(); // dont know the use but its tradition ;p

    public static final String DATABASE_NAME = "contacts.db";
    public static final int DATABASE_VERSION = 1;


    public EmergencyContactsDbHelper(Context context) {
        super(context, DATABASE_NAME,null , DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the steps table
        String SQL_CREATE_EMERGENCYCONTACTS_TABLE = "CREATE TABLE " + ContactEntry.TABLE_NAME
                + " (" + ContactEntry._ID  + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + ContactEntry.COLUMN_CONTACTNAME + " TEXT NOT NULL,"
                + ContactEntry.COLUMN_MOBILE + " TEXT NOT NULL" + ")";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_EMERGENCYCONTACTS_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //The database is still at version 1, so there's nothing to do be done here.

    }

    public boolean insertContact(String name , String mobile){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ContactEntry.COLUMN_CONTACTNAME , name);
        contentValues.put(ContactEntry.COLUMN_MOBILE , mobile);
        long result = db.insert(ContactEntry.TABLE_NAME , null  , contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public boolean updateContact(String id , String name , String number){
        SQLiteDatabase db  = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ContactEntry._ID , id);
        contentValues.put(ContactEntry.COLUMN_CONTACTNAME,name);
        contentValues.put(ContactEntry.COLUMN_MOBILE , number);
        db.update(ContactEntry.TABLE_NAME , contentValues , ContactEntry._ID +" = ? " , new String[] { id });
        return true;

    }

    public  boolean deleteContact(String id){
        SQLiteDatabase db  = this.getWritableDatabase();
        long result = db.delete(ContactEntry.TABLE_NAME , ContactEntry._ID +" = ?" , new String[] { id });
        if(result>0){
            return true;
        }
        return false;

    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+ContactEntry.TABLE_NAME,null);
        return res;
    }

}
