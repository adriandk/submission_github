package com.example.githubapp.following

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONArray
import java.lang.Exception

class ViewModelFollowing : ViewModel(){

    val followingList = MutableLiveData<ArrayList<FollowingData>>()

    internal fun setData(name : String){
        val client = AsyncHttpClient()
        client.addHeader("Author", "token e457ac400f4889b413a7b26f25050f0bbfce0e26")
        client.addHeader("User-agent", "req")
        val listFollowing = ArrayList<FollowingData>()
        val url = "https://api.github.com/users/$name/following"

        client.get(url, object : AsyncHttpResponseHandler(){
            override fun onSuccess(statusCode: Int, headers: Array<out Header>, responseBody: ByteArray) {

                try {
                    val result = String(responseBody)
                    val responseArray = JSONArray(result)

                    for (i in 0 until responseArray.length()){
                        val list = responseArray.getJSONObject(i)
                        val following = FollowingData()
                        following.name = list.getString("login")
                        following.image = list.getString("avatar_url")
                        following.type = list.getString("type")
                        listFollowing.add(following)
                    }
                    followingList.postValue(listFollowing)
                } catch (ex : Exception){
                    Log.d("Error", ex.toString())
                }
            }

            override fun onFailure(statusCode: Int, headers: Array<out Header>?, responseBody: ByteArray?, error: Throwable?) {
                TODO("Not yet implemented")
            }

        })
    }

    internal fun getData() : LiveData<ArrayList<FollowingData>>{
        return followingList
    }

}