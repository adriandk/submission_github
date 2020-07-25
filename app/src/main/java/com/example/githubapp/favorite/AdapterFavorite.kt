package com.example.githubapp.favorite

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.githubapp.DetailActivity
import com.example.githubapp.R
import com.example.githubapp.main.Data
import kotlinx.android.synthetic.main.dataitems.view.*

class AdapterFavorite (private val activity : Activity) : RecyclerView.Adapter<AdapterFavorite.ViewHolder>() {

    var listFavorite = ArrayList<Data>()

    set(listFav) {
        if (listFav.size > 0) {
            this.listFavorite.clear()
        }
        this.listFavorite.addAll(listFav)
        notifyDataSetChanged()
    }

    fun addItem(fav : Data){
        this.listFavorite.add(fav)
        notifyItemChanged(this.listFavorite.size - 1)
    }

    fun updateItem(position: Int, fav: Data){
        this.listFavorite[position] = fav
        notifyItemChanged(position, fav)
    }

    fun removeItem(position: Int){
        this.listFavorite.removeAt(position)
        notifyItemChanged(position)
        notifyItemRangeChanged(position, this.listFavorite.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterFavorite.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.dataitems, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = this.listFavorite.size

    override fun onBindViewHolder(holder: AdapterFavorite.ViewHolder, position: Int) {
        holder.bind(listFavorite[position])
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bind(favoriteData: Data) {
            with(itemView){
                Glide.with(itemView.context)
                    .load(favoriteData.image)
                    .dontAnimate()
                    .into(image_profile)

                name_profile.text = favoriteData.name
                itemView.setOnClickListener {
                    val moveToDetail = Intent(context, DetailActivity::class.java)
                    moveToDetail.putExtra(DetailActivity.DETAIL_DATA, favoriteData)
                    itemView.context.startActivity(moveToDetail)
                }
            }
        }
    }

}