package com.example.tripcast.pager

import android.R.attr.name
import android.R.attr.requiredFeature
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tripcast.Adapter.CityAdapter
import com.example.tripcast.Data.CityResult
import com.example.tripcast.FinalActivity
import com.example.tripcast.R
import com.example.tripcast.databinding.FragmentCityTourBinding


class City_TourFragment : Fragment() {

    val FinalList= mutableListOf<CityResult>()
    private var _binding : FragmentCityTourBinding?= null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCityTourBinding.inflate(inflater, container, false)
        binding.resView.layoutManager= LinearLayoutManager(activity)
        val adapter =  CityAdapter(requireActivity(), getTourName(), FinalList)
        binding.resView.adapter = adapter

        binding.btnBeginCity.setOnClickListener {
            val i = Intent(this@City_TourFragment.requireActivity(),FinalActivity::class.java)
            startActivity(i)
            this.requireActivity().finish()
       }

        return binding.root
    }

    private fun getTourName(): List<CityResult>{
        val CitytourList = listOf<CityResult>(
            CityResult("https://karnatakatourism.org/wp-content/uploads/2020/06/Mysuru-Palace-banner-1920_1100.jpg",3500,"Mysore","Karnataka"),
            CityResult("https://indotoursadventures.com/public/storage/blogs/9c17627593382f6b1fa3d4de49599f5d.jpg",6000,"Dehradun","Uttrakhand"),
            CityResult("https://static.toiimg.com/photo/54559212.cms",9500,"Bangalore","Karnataka"),
            CityResult("https://www.tripsavvy.com/thmb/hG6VCaptGEp1ldoQmZFdF_h0g3k=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/GettyImages-671326926-a3ce195b85c74da28dffdd9e09e08437.jpg",7500,"Lucknow","Uttar Pradesh"),
            CityResult("https://static.toiimg.com/img/100273065/Master.jpg",6500,"Varanasi","Uttar Pradesh"),
            CityResult("https://www.savaari.com/blog/wp-content/uploads/2022/02/photo-1622308644420-b20142dc993c.jpg",8500,"Darjeeling","West Bengal"),
            CityResult("https://staticimg.amarujala.com/assets/images/2019/03/19/750x506/shilong_1552998197.jpeg",5500,"Shilong","Meghalaya"),
            CityResult("https://ak-d.tripcdn.com/images/10081f000001gqhjy23BC_C_640_320_R5_Q70.jpg_.webp?proc=source%2Ftrip",8000,"thiruvananthapuram","Kerala"),
        )
        return CitytourList
    }
}