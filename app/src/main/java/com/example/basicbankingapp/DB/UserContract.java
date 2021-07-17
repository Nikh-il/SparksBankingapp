package com.example.basicbankingapp.DB;

import android.provider.BaseColumns;

public class UserContract {
    private UserContract() {}

    public static class UserEntry implements BaseColumns {
        /** Name of database table for pets */
        public static String TABLE_NAME = "user";

        /** Table Fields */
        public static String _ID = BaseColumns._ID;
        public static String COLUMN_USER_NAME ="name";
        public static String COLUMN_USER_ACCOUNT_NUMBER ="accountNo";
        public static String COLUMN_USER_EMAIL ="email";
        public static String COLUMN_USER_IFSC_CODE ="ifscCode";
        public static String COLUMN_USER_PHONE_NO ="phoneNo";
        public static String COLUMN_USER_ACCOUNT_BALANCE ="balance";
    }
}
