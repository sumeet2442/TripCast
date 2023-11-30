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
import com.example.tripcast.R
import com.example.tripcast.databinding.FragmentHikeBinding
import com.example.tripcast.databinding.FragmentSurfBinding


class HikeFragment : Fragment() {
    private var _binding : FragmentHikeBinding?= null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHikeBinding.inflate(inflater, container, false)
        binding.resView.layoutManager= LinearLayoutManager(activity)
        val adapter =  CityAdapter(this@HikeFragment.requireActivity(), getHikeName(), mutableListOf<CityResult>())
        binding.resView.adapter = adapter
        return binding.root
    }

    private fun getHikeName(): List<CityResult> {
        val HikenameList= listOf<CityResult>(
            CityResult("https://www.gokyo.in/cdn/shop/files/1_2.jpg?v=1691231450",4500,"Mariund Trek","Chattisgarh"),
            CityResult("https://harstuff-travel.org/wp-content/uploads/2019/03/LRM_EXPORT_929102018503574_20190214_142502283.jpeg",3800,"Tiramisu Hike","Himachal Pradesh"),
            CityResult("https://blog.weekendthrill.com/wp-content/uploads/2016/07/1-10.jpg",6000,"Triund Trek","Himachal Pradesh"),
            CityResult("https://assets-global.website-files.com/5ca5fe687e34be0992df1fbe/63a2e2212c0c6b4ab82be82a_TREKKING%20MOUNTAIN%20AH22%20COL%20DES%20ARAVIS%20-%20006%20---%20Expires%20on%2014-04-2027.jpg",5600,"Newman Hike","Karnataka"),
            CityResult("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ36uhLPJWnx6Hn9DBHiEEtfaVw4Y8EEvB9AQ&usqp=CAU",6000,"Hillmount Trek","Arunachal Pradesh"),
            CityResult("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRW_pO3VH4wpIUny3y6VadZIIKSrPlh15nRbg&usqp=CAU",4500,"Mariund Trek","Chattisgarh"),
            CityResult("https://images.prismic.io/indiahike/1905-feature-Dayara-Bugyal-trek-Trekking-with-children-kids-Indiahikes-Nitesh-Kumar.jpg?auto=compress,format&rect=0,0,1500,844&w=1500&h=844",7200,"Trith Hike","Uttrakhand"),
            CityResult("https://www.adityabirlacapital.com/healthinsurance/active-together/wp-content/uploads/2020/01/Trekking-Walking-Destinations-in-India_Blog.jpg",5400,"Goraknath Trek","Jharkhand"),
            CityResult("https://hikelag.co.za/wp-content/uploads/2022/01/hikelag21.jpg",5800,"Trojan Trek","Sikkim"),

        )
        return HikenameList
    }
}