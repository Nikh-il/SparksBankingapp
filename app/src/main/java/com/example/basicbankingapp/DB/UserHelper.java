package com.example.basicbankingapp.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.basicbankingapp.DB.UserContract.UserEntry;
import com.example.basicbankingapp.Data.User;

public class UserHelper extends SQLiteOpenHelper {

    String TABLE_NAME = UserEntry.TABLE_NAME;

    /** Name of the database file */
    private static String DATABASE_NAME = "User.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.*/
    private static final int DATABASE_VERSION = 2;

    public UserHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_USER_TABLE =  "CREATE TABLE " + UserEntry.TABLE_NAME + " ("
                + UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " INTEGER, "
                + UserEntry.COLUMN_USER_NAME + " VARCHAR, "
                + UserEntry.COLUMN_USER_EMAIL + " VARCHAR, "
                + UserEntry.COLUMN_USER_IFSC_CODE + " VARCHAR, "
                + UserEntry.COLUMN_USER_PHONE_NO + " VARCHAR, "
                + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " INTEGER NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_USER_TABLE);

        // Insert Into Table
        db.execSQL("insert into " + TABLE_NAME + " values(1546,'Nik kapoor', 'Nik@gmail.com','5465','7895481648', 20000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1982,'Mansi agrawal', 'mansi@gmail.com','5465','9567898238', 18000)");
        db.execSQL("insert into " + TABLE_NAME + " values(8654,'Ram kapoor', 'Ram@gmail.com','7854','8933765896', 11000)");
        db.execSQL("insert into " + TABLE_NAME + " values(4568,'Gagan kapoor', 'Ggkap@gmail.com','2549','9976932238', 9000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7410,'Sneha goyal', 'sneha@gmail.com','9874','6585648962', 1500)");
        db.execSQL("insert into " + TABLE_NAME + " values(8529,'Rekha kapoor', 'rekha@gmail.com','5648','456640238', 8500)");
        db.execSQL("insert into " + TABLE_NAME + " values(3698,'Yashu', 'yashu@gmail.com','7561','124640215', 5468)");
        db.execSQL("insert into " + TABLE_NAME + " values(7853,'Kushal gupta', 'kushal@gmail.com','9823','4985021539', 6549)");
        db.execSQL("insert into " + TABLE_NAME + " values(4562,'Preet kaur', 'Preet@gmail.com','1567','7809565238', 2987)");
        db.execSQL("insert into " + TABLE_NAME + " values(2365,'Aman jain', 'aman@gmail.com','6947','4592591201', 19090)");
        db.execSQL("insert into " + TABLE_NAME + " values(7854,'harman Sharma', 'harman@gmail.com','6123','8455154800', 9019)");
        db.execSQL("insert into " + TABLE_NAME + " values(3621,'shubham negi', 'negi@gmail.com','7812','997896549', 12870)");
        db.execSQL("insert into " + TABLE_NAME + " values(1122,'dev kalra', 'dev@gmail.com','7125','91475541001', 4357)");
        db.execSQL("insert into " + TABLE_NAME + " values(9512,'naman gupta', 'naman@gmail.com','6589','8945342205', 9735)");
        db.execSQL("insert into " + TABLE_NAME + " values(7530,'Hiskey khanna', 'hiskey@gmail.com','36548','987641266', 9218)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME);
            onCreate(db);
        }
    }

    public Cursor readAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME, null);
        return cursor;
    }

    public Cursor readParticularData (int accountNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME + " where " +
                                        UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo, null);
        return cursor;
    }

    public void updateAmount(int accountNo, int amount) {
        Log.d ("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + UserEntry.TABLE_NAME + " set " + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);
    }
}