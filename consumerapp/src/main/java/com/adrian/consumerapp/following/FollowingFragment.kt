package com.adrian.consumerapp.following

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
import kotlinx.android.synthetic.main.fragment_following.*

class FollowingFragment : Fragment() {

    lateinit var adapter : AdapterFollowing
    lateinit var viewModel : ViewModelFollowing

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_following, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val getDetailData = activity?.intent?.getParcelableExtra(DetailActivity.DETAIL_DATA) as Data
//
//        val username : String = getDetailData.name.toString()
//
//        adapter = AdapterFollowing()
//        adapter.notifyDataSetChanged()
//
//        following_list.layoutManager = LinearLayoutManager(context)
//        following_list.adapter = adapter
//
//        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(ViewModelFollowing::class.java)
//
//        viewModel.setData(username)
//        viewModel.getData().observe(viewLifecycleOwner, Observer { following ->
//            adapter.setData(following)
//        })

    }
}