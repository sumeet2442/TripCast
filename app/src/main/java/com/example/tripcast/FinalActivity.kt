package com.example.tripcast

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.example.tripcast.databinding.ActivityFinalBinding

class FinalActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFinalBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFinalBinding.inflate(layoutInflater)

        var textState = findViewById<TextView>(R.id.tvStates)
        var textRate = findViewById<TextView>(R.id.tvRate)
        var data:String = ""
        var rate:Int = 0
        var sharedPreferences = this@FinalActivity.getSharedPreferences("FinalData",   Context.MODE_PRIVATE)
        data = sharedPreferences.getString("State","").toString()
        rate = sharedPreferences.getInt("Rate",0)
        Log.d("Mera State", data)
        Log.d("Mera Rate", rate.toString())
        binding.tvStates.text = data
        binding.tvRate.text = "₹"+rate.toString()
        setContentView(binding.root)
    }

    override fun onDestroy() {
        val sharedPreferences = this!!.applicationContext.getSharedPreferences("FinalData",   Context.MODE_PRIVATE)
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("State", "").apply()
            sharedPreferences.edit().putInt("Rate", 0).apply()
        }
        super.onDestroy()
    }

    override fun onBackPressed() {
        val sharedPreferences = this!!.applicationContext.getSharedPreferences("FinalData",   Context.MODE_PRIVATE)
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("State", "").apply()
            sharedPreferences.edit().putInt("Rate", 0).apply()
        }
        val i = Intent(this,PlanSelectorActivity::class.java)
        startActivity(i)
        super.onBackPressed()
    }

}