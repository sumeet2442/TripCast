package com.example.tripcast

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sharedPreferences = this!!.applicationContext.getSharedPreferences("FinalData",   Context.MODE_PRIVATE)
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("State", "").apply()
            sharedPreferences.edit().putInt("Rate", 0).apply()
        }
        Handler().postDelayed(kotlinx.coroutines.Runnable{
            val i = Intent(this@MainActivity,PlanSelectorActivity::class.java)
            startActivity(i)
        },4800)
    }
}