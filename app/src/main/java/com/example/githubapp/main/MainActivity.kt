package com.example.githubapp.main

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubapp.favorite.FavoriteActivity
import com.example.githubapp.R
import com.example.githubapp.SettingActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter : MainAdapter
    lateinit var viewModel : ViewModel

    lateinit var searchManager : SearchManager
    lateinit var searchView : SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = MainAdapter()
        adapter.notifyDataSetChanged()

        list_item.layoutManager = LinearLayoutManager(this)
        list_item.adapter = adapter

        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(
            ViewModel::class.java)

        showLoading(false)
        viewModel.getData().observe(this, Observer { User ->
            if (User != null){
                adapter.setData(User)
                showLoading(false)
            } else {
                showLoading(false)
            }
        })
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.search_menu, menu)

        searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        searchView = menu.findItem(R.id.search_bar).actionView as SearchView

        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchView.queryHint = resources.getString(R.string.search)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{

            override fun onQueryTextSubmit(string: String): Boolean {
                viewModel.setData(string)
                showLoading(true)
                return true
            }

            override fun onQueryTextChange(string: String): Boolean {
                return false
            }
        })
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.setting -> {
                val intent = Intent(this@MainActivity, SettingActivity::class.java)
                startActivity(intent)
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                return true
            }
            R.id.favorite -> {
                val intent = Intent(this@MainActivity, FavoriteActivity::class.java)
                startActivity(intent)
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                return true
            }
            else -> return true
        }
    }

    private fun showLoading(state : Boolean){
        if (state){
            loading.visibility = View.VISIBLE
        } else {
            loading.visibility = View.INVISIBLE
        }
    }


    override fun onBackPressed() {
        if (!searchView.isIconified){
            searchView.setQuery("", false)
            searchView.isIconified = true
        } else {
            super.onBackPressed()
        }
    }
}