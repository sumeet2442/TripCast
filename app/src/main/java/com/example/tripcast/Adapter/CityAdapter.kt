package com.example.tripcast.Adapter

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.provider.Settings.Global.getString
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tripcast.Data.CityResult
import com.example.tripcast.FinalActivity
import com.example.tripcast.R
import kotlinx.coroutines.NonDisposableHandle.parent

class CityAdapter(var activity: Activity, private val  city: List<CityResult>, var FinalList:MutableList<CityResult>):
    RecyclerView.Adapter<CityAdapter.Holder>() {

    class Holder(itemView: View, var activity: Activity) : RecyclerView.ViewHolder(itemView) {

        private val tDes : TextView = itemView.findViewById(R.id.t_destination)
        private val tCity : TextView = itemView.findViewById(R.id.t_city)
        private val tRate : TextView = itemView.findViewById(R.id.t_rate)
        private val image : ImageView = itemView.findViewById(R.id.imgView)
        private val cb : CheckBox = itemView.findViewById(R.id.checkBox)

        fun bind(city: CityResult){
            tDes.text = city.spot
            tCity.text = city.state
            tRate.text = "₹" + city.rate.toString()
            Glide.with(itemView).load(city.img).into(image);
            cb.setOnClickListener {
//                finalList.add(
//                    CityResult(city.img, city.rate, city.spot, city.state )
//                )
                val sharedPreferences = activity!!.applicationContext.getSharedPreferences("FinalData",   Context.MODE_PRIVATE)
                var data = sharedPreferences.getString("State","").toString()
                var rate = sharedPreferences.getInt("Rate",0)
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putString("State", data+city.spot+"("+city.state+")"+"\n").apply()
                    sharedPreferences.edit().putInt("Rate", rate+city.rate).apply()
                }
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.list_of_adventure, parent, false)
        return Holder(view, activity)
    }

    override fun getItemCount(): Int = city.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val message = city[position]
        holder.bind(message)
    }
}

//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
//        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.list_of_adventure, parent, false)
//        return Holder(view)
//    }
//
//    override fun onBindViewHolder(holder: Holder, position: Int) {
//        val message = city[position]
//        holder.bind(message)
//    }
//
//    override fun getItemCount() = city.size

//}