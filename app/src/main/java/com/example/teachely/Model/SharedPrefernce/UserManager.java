package com.example.teachely.Model.SharedPrefernce;

import android.content.Context;
import android.content.SharedPreferences;

public class UserManager {
    private SharedPreferences sharedPreferences;

    public UserManager(Context context) {
        sharedPreferences = context.getSharedPreferences("user_information", Context.MODE_PRIVATE);
    }

    public void saveTeacherInformation(String firstName, String lastName,int age, String gender) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SharePrefsKey.FIRST_NAME_KEY, firstName);
        editor.putString(SharePrefsKey.LAST_NAME_KEY, lastName);
        editor.putInt(SharePrefsKey.AGE_KEY, age);
        editor.putString(SharePrefsKey.GENDER_KEY, gender);
        editor.apply();
    }

    public boolean checkInformation() {
        String firstName = sharedPreferences.getString(SharePrefsKey.FIRST_NAME_KEY, null);
        String lastName = sharedPreferences.getString(SharePrefsKey.LAST_NAME_KEY, null);
        if (firstName != null && lastName != null) {
            return true;
        }
        return false;
    }

    public void saveStringField(String key, String value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public void removeAllInformation() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

    public void removeField(String key) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(key);
        editor.apply();
    }

    public String getStringField(String key){
        return sharedPreferences.getString(key,null);
    }
}
