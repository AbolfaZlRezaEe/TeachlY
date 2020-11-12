package com.example.teachely.SharedPrefernce;

import android.content.Context;
import android.content.SharedPreferences;

public class UserManager {
    private SharedPreferences sharedPreferences;

    public UserManager(Context context) {
        sharedPreferences = context.getSharedPreferences("user_information", Context.MODE_PRIVATE);
    }

    public void saveUserInformation(String firstName, String lastName, String schoolName, String gender, int age) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("first_name", firstName);
        editor.putString("last_name", lastName);
        editor.putString("school_name", schoolName);
        editor.putString("gender", gender);
        editor.putInt("age", age);
        editor.apply();
    }

    public boolean checkInformation() {
        String firstName = sharedPreferences.getString("first_name", null);
        String lastName = sharedPreferences.getString("last_name", null);
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

    public String getFirstName() {
        return sharedPreferences.getString("first_name", "");
    }

    public String getLastName() {
        return sharedPreferences.getString("last_name", "");
    }

    public String getSchoolName() {
        return sharedPreferences.getString("school_name", "");
    }

    public String getGender() {
        return sharedPreferences.getString("gender", "");
    }

    public int getAge() {
        return sharedPreferences.getInt("age", 0);
    }
}
