package com.example.alertika.data;

import android.provider.BaseColumns;

public final class ContactsContract {

    private  ContactsContract(){}

    public static final class ContactEntry implements BaseColumns {

        public static final String TABLE_NAME  = "emergencycontacts";

        public static final String COLUMN_CONTACTNAME =  "name";

        public static final String COLUMN_MOBILE = "mobileno";

    }


}
