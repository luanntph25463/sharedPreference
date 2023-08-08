package com.example.sharedpreference

import android.content.Context
import android.content.SharedPreferences

class UserManager(context: Context) {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("UserPreference", Context.MODE_PRIVATE)
    // save user
    fun saveUser(user: String) {
        sharedPreferences.edit().putString("Username", user).apply()
    }
    //save getUser
    fun getUser(): String? {
        return sharedPreferences.getString("Username", null)
    }
    //save Age
    fun saveAge(age: Int) {
        sharedPreferences.edit().putInt("Age", age).apply()
    }
    //save Age
    fun getAge(): Int? {
        return sharedPreferences.getInt("Age", 0)
    }
}