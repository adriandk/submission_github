package com.example.githubapp.following

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.githubapp.R
import kotlinx.android.synthetic.main.dataitems.view.*

class AdapterFollowing : RecyclerView.Adapter<AdapterFollowing.ViewHolder>(){

    val followingList = ArrayList<FollowingData>()

    fun setData(following : ArrayList<FollowingData>){
        followingList.clear()
        followingList.addAll(following)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterFollowing.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.dataitems, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int  = followingList.size

    override fun onBindViewHolder(holder: AdapterFollowing.ViewHolder, position: Int) {
        holder.bind(followingList[position])
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        fun bind(followingData : FollowingData){
            with(itemView){
                Glide.with(itemView)
                    .load(followingData.image)
                    .dontAnimate()
                    .into(image_profile)


                name_profile.text = followingData.name
            }
        }
    }

}