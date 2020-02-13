package com.hsbc.kinetic.login.dbb

import android.content.Context
import android.content.SharedPreferences

class SharedPref {
    private var PRIVATE_MODE = 0
    private var Kinetic_Preference = "Kinetic_Preference"
    private val USER_NAME = "user_name"
    private val USER_PASS = "user_pass"

    fun saveUserName(context: Context?, userName: String) {
        val sharedPref: SharedPreferences = context?.getSharedPreferences(Kinetic_Preference, PRIVATE_MODE)!!
        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.putString(USER_NAME, userName)
        editor.apply()
        editor.commit()
    }

    fun saveUserPassword(context: Context?, userPass: String) {
        val sharedPref: SharedPreferences = context!!.getSharedPreferences(Kinetic_Preference, PRIVATE_MODE)
        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.putString(USER_PASS, userPass)
        editor.apply()
        editor.commit()

    }
}