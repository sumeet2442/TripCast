package com.example.tripcast.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.tripcast.pager.City_TourFragment
import com.example.tripcast.pager.HikeFragment
import com.example.tripcast.pager.SurfFragment

class selectAdapt(fragmentManager: FragmentManager,lifecycle: Lifecycle):FragmentStateAdapter(fragmentManager,lifecycle) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        when(position){
            0->return HikeFragment()
            1->return SurfFragment()
            2->return City_TourFragment()
            else->return HikeFragment()
        }
    }
}