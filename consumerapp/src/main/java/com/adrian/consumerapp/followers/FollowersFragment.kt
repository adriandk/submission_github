package com.adrian.consumerapp.followers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.adrian.consumerapp.DetailActivity
import com.adrian.consumerapp.R
import com.adrian.consumerapp.Data
import kotlinx.android.synthetic.main.fragment_followers.*

class FollowersFragment : Fragment() {

    private lateinit var adapter : AdapterFollowers
    private lateinit var viewModel : ViewModelFollowers

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_followers, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//
//        val getDetailData = activity?.intent?.getParcelableExtra(DetailActivity.DETAIL_DATA) as Data
//
//        val username : String = getDetailData.name.toString()
//
//        adapter = AdapterFollowers()
//        adapter.notifyDataSetChanged()
//
//        followers_list.layoutManager = LinearLayoutManager(context)
//        followers_list.adapter = adapter
//
//        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(ViewModelFollowers::class.java)
//
//        viewModel.setData(username)
//        viewModel.getData().observe(viewLifecycleOwner, Observer { followers ->
//            adapter.setData(followers)
//        })
    }
}