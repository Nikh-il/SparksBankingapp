package com.example.basicbankingapp.DB;

import android.provider.BaseColumns;

public class TransactionContract {
    private TransactionContract() {}

    public static class TransactionEntry implements BaseColumns {
        /**Name of database table for pets*/
        public final static String TABLE_NAME = "Transaction_table";

        /**Table Fields*/
        public static String _ID = BaseColumns._ID;
        public static String COLUMN_FROM_NAME = "from_name";
        public static String COLUMN_TO_NAME = "to_name";
        public static String COLUMN_AMOUNT = "amount";
        public static String COLUMN_STATUS = "status";
    }
}
