package com.example.supernaaahigame.konexioa.db;

import android.provider.BaseColumns;

public class DBUser1 {
    private DBUser1() {
    }

    public static final class DbBaseColumn implements BaseColumns {
        public static final String TABLE_NAME = "app_users";
        public static final String COLUMN_NAME="name";
        public static final String COLUMN_PASSWORD = "password";
    }
}