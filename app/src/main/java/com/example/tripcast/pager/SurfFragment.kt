package com.example.tripcast.pager

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tripcast.Adapter.CityAdapter
import com.example.tripcast.Data.CityResult
import com.example.tripcast.FinalActivity
import com.example.tripcast.databinding.FragmentSurfBinding


class SurfFragment : Fragment() {
    private var _binding : FragmentSurfBinding?= null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSurfBinding.inflate(inflater, container, false)
        binding.resView.layoutManager= LinearLayoutManager(activity)
        val adapter =  CityAdapter(requireActivity(), getSurfName(), mutableListOf<CityResult>())
        binding.resView.adapter = adapter
        return binding.root
    }

    private fun getSurfName():List<CityResult>{
        val SurfList = listOf<CityResult>(
            CityResult("https://escales.ponant.com/wp-content/uploads/2020/12/plage.jpg",6000,"Sunnies Beach","Goa"),
            CityResult("https://www.gohawaii.com/sites/default/files/hero-unit-images/11500_mauibeaches.jpg",5000,"Gokarna Beach","Karnataka"),
            CityResult("https://images.unsplash.com/photo-1507525428034-b723cf961d3e?q=80&w=1000&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxleHBsb3JlLWZlZWR8MXx8fGVufDB8fHx8fA%3D%3D",6500,"Lokmanya Beach","Maharastra"),
            CityResult("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRT2Hu471MDjvRQWWU3Auvjai38qFACDA_3jg&usqp=CAU",3800,"Sokute Surf","Goa"),
            CityResult("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQMjMobL8ahojge_JudfgojmMBUsIwAf8e5rA&usqp=CAU",5500,"Ragana Beach","Kerala"),
            CityResult("https://img.veenaworld.com/wp-content/uploads/2022/04/Enjoy-A-Romantic-Getaway-Amidst-Beautiful-Beaches-in-the-Maldives.jpg",8000,"Imnikov Beach","Andra Pradesh"),
            CityResult("https://cityfurnish.com/blog/wp-content/uploads/2023/08/beautiful-tropical-beach-sea.jpg",5200,"Tulip Beach","WestBengal"),

        )
        return SurfList
    }
}