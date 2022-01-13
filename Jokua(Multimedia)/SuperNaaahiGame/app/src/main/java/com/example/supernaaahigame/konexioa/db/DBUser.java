package com.example.supernaaahigame.konexioa.db;

import android.provider.BaseColumns;
public class DBUser {
    private DBUser() {
    }

    public static final class DbBaseColumn implements BaseColumns {
        public static final String TABLE_NAME = "app_users";

        public static final String COLUMN_USERNAME = "username";
        public static final String COLUMN_PASSWORD = "password";
    }
}