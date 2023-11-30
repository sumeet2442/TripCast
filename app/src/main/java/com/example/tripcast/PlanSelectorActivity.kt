package com.example.tripcast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.example.tripcast.Adapter.selectAdapt
import com.example.tripcast.databinding.ActivityPlanSelectorBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class PlanSelectorActivity : AppCompatActivity() {
    private var tabTitle = arrayOf("Hiking","Beaches","City Tour")
    private lateinit var binding: ActivityPlanSelectorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlanSelectorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var pager = findViewById<ViewPager2>(R.id.pagerContent)
        var tab = findViewById<TabLayout>(R.id.tabSelect)
        pager.adapter = selectAdapt(supportFragmentManager,lifecycle)

        TabLayoutMediator(tab,pager){
                tab,position ->
            tab.text = tabTitle[position]
        }.attach()

    }

    override fun onBackPressed() {
        Handler().postDelayed({
            Toast.makeText(this,"Thanks for using the App :)", Toast.LENGTH_SHORT).show()
        },1500)
        super.onDestroy()
        super.onBackPressed()
    }
}