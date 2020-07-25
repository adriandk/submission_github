package com.example.githubapp.favorite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubapp.R
import com.example.githubapp.database.DatabaseContract.NoteColums.Companion.CONTENT_URI
import com.example.githubapp.database.FavoriteHelper
import com.example.githubapp.database.MappingHelper
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
                val cursor = contentResolver?.query(CONTENT_URI, null, null, null, null)
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
        overridePendingTransition(R.anim.slide_out_right, R.anim.slide_in_left)
    }

    override fun onResume() {
        super.onResume()
        loadData()
    }

//    override fun onDestroy() {
//        super.onDestroy()
//        favoriteHelper.close()
//    }

//    override fun onPause() {
//        super.onPause()
//        favoriteHelper.close()
//    }
}