package com.example.teachely.Model.SharedPrefernce;

import android.content.Context;
import android.content.SharedPreferences;

public class UserManager {
    private SharedPreferences sharedPreferences;

    public UserManager(Context context) {
        sharedPreferences = context.getSharedPreferences("user_information", Context.MODE_PRIVATE);
    }

    public void saveUserInformation(String firstName, String lastName, String schoolName, String gender, int age) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SharePrefsKey.FIRST_NAME_KEY, firstName);
        editor.putString(SharePrefsKey.LAST_NAME_KEY, lastName);
        editor.putString(SharePrefsKey.SCHOOL_NAME_KEY, schoolName);
        editor.putString(SharePrefsKey.GENDER_KEY, gender);
        editor.putInt(SharePrefsKey.AGE_KEY, age);
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
    public String getFirstName() {
        return sharedPreferences.getString(SharePrefsKey.FIRST_NAME_KEY, "");
    }

    public String getLastName() {
        return sharedPreferences.getString(SharePrefsKey.LAST_NAME_KEY, "");
    }

    public String getSchoolName() {
        return sharedPreferences.getString(SharePrefsKey.SCHOOL_NAME_KEY, "");
    }

    public String getGender() {
        return sharedPreferences.getString(SharePrefsKey.GENDER_KEY, "");
    }

    public int getAge() {
        return sharedPreferences.getInt(SharePrefsKey.AGE_KEY, 0);
    }
}
