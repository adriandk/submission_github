package com.adrian.consumerapp.followers

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONArray
import java.lang.Exception

class ViewModelFollowers : ViewModel() {

    val followersList = MutableLiveData<ArrayList<FollowersData>>()

    internal fun setData(name : String){
        val client = AsyncHttpClient()
        client.addHeader("Author", "token e457ac400f4889b413a7b26f25050f0bbfce0e26")
        client.addHeader("User-agent", "req")
        val listFollowers =ArrayList<FollowersData>()
        val url = "https://api.github.com/users/$name/followers"

        client.get(url, object : AsyncHttpResponseHandler(){
            override fun onSuccess(statusCode: Int, headers: Array<out Header>, responseBody: ByteArray) {
                try {
                    val result = String(responseBody)
                    val responseArray = JSONArray(result)

                    for (i in 0 until responseArray.length()){
                        val list = responseArray.getJSONObject(i)
                        val followers = FollowersData()
                        followers.name = list.getString("login")
                        followers.image = list.getString("avatar_url")
                        followers.type = list.getString("type")
                        listFollowers.add(followers)
                    }
                    followersList.postValue(listFollowers)
                } catch (ex : Exception){
                    Log.d("Error", ex.toString())
                }
            }

            override fun onFailure(statusCode: Int, headers: Array<out Header>?, responseBody: ByteArray?, error: Throwable?) {
            }

        })

    }

    internal fun getData() : LiveData<ArrayList<FollowersData>>{
        return followersList
    }

}