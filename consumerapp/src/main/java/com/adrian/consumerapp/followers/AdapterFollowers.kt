package com.adrian.consumerapp.followers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adrian.consumerapp.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.dataitems.view.*

class AdapterFollowers : RecyclerView.Adapter<AdapterFollowers.ViewHolder>(){

    private val followersList = ArrayList<FollowersData>()

    fun setData(followers : ArrayList<FollowersData>){
        followersList.clear()
        followersList.addAll(followers)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterFollowers.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.dataitems, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdapterFollowers.ViewHolder, position: Int) {
        holder.bind(followersList[position])
    }

    override fun getItemCount(): Int = followersList.size

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        fun bind(followersData : FollowersData){
            with(itemView){

                Glide.with(itemView.context)
                    .load(followersData.image)
                    .dontAnimate()
                    .into(image_profile)

                name_profile.text = followersData.name
            }
        }
    }

}