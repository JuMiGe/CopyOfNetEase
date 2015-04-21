/*
 * Copyright (c) 2014.
 * Shijiebang
 */

package com.jumige.android.common.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Map;
import java.util.Set;


/**
 * Created by cyning on 10/30/14.
 */
public class PreferenceUtils {


        private static final String TAG = "Prefs";

        static PreferenceUtils singleton = null;

        static SharedPreferences preferences;

        static SharedPreferences.Editor editor;

        PreferenceUtils(Context context,String fileName) {
            String preFileName = fileName;
            if (StringUtils.isEmpty(fileName))
                preFileName = TAG;

            preferences = context.getSharedPreferences(preFileName, Context.MODE_PRIVATE);
            editor = preferences.edit();
        }

        public static PreferenceUtils with(Context context,String fileName) {
            if (singleton == null) {
                singleton = new Builder(context,fileName).build();
            }
            return singleton;
        }

        public void save(String key, boolean value) {
            editor.putBoolean(key, value).apply();
        }

        public void save(String key, String value) {
            editor.putString(key, value).apply();
        }

        public void save(String key, int value) {
            editor.putInt(key, value).apply();
        }

        public void save(String key, float value) {
            editor.putFloat(key, value).apply();
        }

        public void save(String key, long value) {
            editor.putLong(key, value).apply();
        }

        public void save(String key, Set<String> value) {
            editor.putStringSet(key, value).apply();
        }

        public boolean getBoolean(String key, boolean defValue) {
            return preferences.getBoolean(key, defValue);
        }

        public String getString(String key, String defValue) {
            return preferences.getString(key, defValue);
        }

        public int getInt(String key, int defValue) {
            return preferences.getInt(key, defValue);
        }

        public float getFloat(String key, float defValue) {
            return preferences.getFloat(key, defValue);
        }

        public long getLong(String key, long defValue) {
            return preferences.getLong(key, defValue);
        }

        public Set<String> getStringSet(String key, Set<String> defValue) {
            return preferences.getStringSet(key, defValue);
        }

        public Map<String, ?> getAll() {
            return preferences.getAll();
        }

        public void remove(String key) {
            editor.remove(key).apply();
        }

        private static class Builder {

            private final Context context;
            private String fileName;

            public Builder(Context context,String fileName) {
                if (context == null) {
                    throw new IllegalArgumentException("Context must not be null.");
                }
                this.context = context.getApplicationContext();
                this.fileName = fileName;
            }

            /**
             * Method that creates an instance of Prefs
             *
             * @return an instance of Prefs
             */
            public PreferenceUtils build() {
                return new PreferenceUtils(context,fileName);
            }
        }


}
