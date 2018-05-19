package com.a4nesia.whatsappclone.tools;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferences {
    private static String TAG = "WA";
    public static void setStringPreference(String prefName, String value, Context context){
        SharedPreferences.Editor editor = context.getSharedPreferences(TAG,context.MODE_PRIVATE).edit();
        editor.putString(prefName,value);
        editor.apply();
    }
    public static void setIntPreference(String prefName, int value, Context context){
        SharedPreferences.Editor editor = context.getSharedPreferences(TAG,context.MODE_PRIVATE).edit();
        editor.putInt(prefName,value);
        editor.apply();
    }
    public static void setBooleanPreference(String prefName, boolean value, Context context){
        SharedPreferences.Editor editor = context.getSharedPreferences(TAG,context.MODE_PRIVATE).edit();
        editor.putBoolean(prefName,value);
        editor.apply();
    }

    public static String getStringPreference(String prefName, Context context){
        SharedPreferences preferences = context.getSharedPreferences(TAG,context.MODE_PRIVATE);
        String value = preferences.getString(prefName,"");
        return value;
    }

    public static int getIntPreference(String prefName, Context context){
        SharedPreferences preferences = context.getSharedPreferences(TAG,context.MODE_PRIVATE);
        int value = preferences.getInt(prefName,0);
        return value;
    }

    public static boolean getBooleanPreference(String prefName, Context context){
        SharedPreferences preferences = context.getSharedPreferences(TAG,context.MODE_PRIVATE);
        boolean value = preferences.getBoolean(prefName,false);
        return value;
    }
}
