package com.adrian.consumerapp

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.adrian.consumerapp.followers.FollowersFragment
import com.adrian.consumerapp.following.FollowingFragment


class FragmentAdapter (private val context: Context, fragmentManager: FragmentManager) : FragmentPagerAdapter (fragmentManager){

    private val fragment = listOf(
        FollowersFragment(),
        FollowingFragment()
    )

    private val tabText = intArrayOf(R.string.followers, R.string.following)

    override fun getItem(position: Int): Fragment {
        return fragment [position]
    }

    override fun getCount(): Int {
        return fragment.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(tabText[position])
    }

}