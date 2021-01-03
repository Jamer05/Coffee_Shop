package com.java.mahbixver20;

import android.content.Context;
import android.content.SharedPreferences;

public class SaveSharePreferences {
    Context context;
    SharedPreferences sharedPreferences;

    public SaveSharePreferences(Context context){
        this.context = context;
        sharedPreferences = context.getSharedPreferences("apreferences",Context.MODE_PRIVATE);

    }
    public void setState(Boolean b){
        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.putBoolean("editor",b);
        editor.apply();
    }
    public  boolean getState(){
        return sharedPreferences.getBoolean("editor",false);
    }
}
