package com.example.githubapp.main

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.githubapp.DetailActivity
import com.example.githubapp.R
import kotlinx.android.synthetic.main.dataitems.view.*

class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder>(){

    private val user = ArrayList<Data>()

    fun setData(items : ArrayList<Data>){
        user.clear()
        user.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.dataitems, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(user[position])
    }

    override fun getItemCount(): Int = user.size

    inner class ViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView){
        fun bind(userItems : Data){
            with(itemView){

                Glide.with(itemView.context)
                    .load(userItems.image)
                    .dontAnimate()
                    .into(image_profile)

                name_profile.text = userItems.name

                itemView.setOnClickListener {
                    val moveToDetail = Intent(context, DetailActivity::class.java)
                    moveToDetail.putExtra(DetailActivity.DETAIL_DATA, userItems)
                    itemView.context.startActivity(moveToDetail)
                }
            }
        }
    }

}