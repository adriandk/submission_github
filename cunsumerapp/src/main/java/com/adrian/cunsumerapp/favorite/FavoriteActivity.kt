package com.adrian.cunsumerapp.favorite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.adrian.cunsumerapp.FavoriteHelper
import com.adrian.cunsumerapp.MappingHelper
import com.adrian.cunsumerapp.R
import kotlinx.android.synthetic.main.activity_favorite.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class FavoriteActivity : AppCompatActivity() {

    private lateinit var adapter: AdapterFavorite
    private lateinit var favoriteHelper: FavoriteHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)
        supportActionBar?.title = "Favorite"

        favoriteHelper = FavoriteHelper(this)
        adapter = AdapterFavorite(this)

        rv_fav.layoutManager = LinearLayoutManager(this)
        rv_fav.adapter = adapter

        loadData()
    }

    private fun loadData() {
        GlobalScope.launch(Dispatchers.Main) {
            val deferredNotes = async(Dispatchers.IO){
                val cursor = favoriteHelper.queryAll()
                MappingHelper.mapCursorToarrayList(cursor)

            }

            val notes = deferredNotes.await()
            if (notes.size > 0){
                adapter.listFavorite = notes
                adapter.notifyDataSetChanged()
            } else {
                adapter.listFavorite = ArrayList()
                Toast.makeText(this@FavoriteActivity, "GADA", Toast.LENGTH_SHORT).show()
            }

        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    override fun onResume() {
        super.onResume()
        favoriteHelper.open()
        loadData()
    }

    override fun onDestroy() {
        super.onDestroy()
        favoriteHelper.close()
    }

//    override fun onPause() {
//        super.onPause()
//        favoriteHelper.close()
//    }
}