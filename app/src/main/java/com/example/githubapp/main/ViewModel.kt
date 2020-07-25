package com.example.githubapp.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONObject
import java.lang.Exception

class ViewModel : ViewModel(){

    val listUser = MutableLiveData<ArrayList<Data>>()

    internal fun setData(name : String){
        val client = AsyncHttpClient()
        client.addHeader("Author", "token e457ac400f4889b413a7b26f25050f0bbfce0e26")
        client.addHeader("User-agent", "req")
        val listData =ArrayList<Data>()
        val url = "https://api.github.com/search/users?q=$name"

        client.get(url, object : AsyncHttpResponseHandler(){
            override fun onSuccess(statusCode: Int, headers: Array<out Header>, responseBody: ByteArray) {

                try {
                    val result = String(responseBody)
                    val resObject = JSONObject(result)
                    val list = resObject.getJSONArray("items")

                    for (i in 0 until list.length()){
                        val user = list.getJSONObject(i)
                        val userData = Data()
                        userData.name = user.getString("login")
                        userData.image = user.getString("avatar_url")
                        userData.id = user.getInt("id")
                        listData.add(userData)
                    }
                    listUser.postValue(listData)
                } catch (ex : Exception){
                    Log.d("Error", ex.toString())
                }
            }

            override fun onFailure(statusCode: Int, headers: Array<out Header>?, responseBody: ByteArray?, error: Throwable?) {
            }

        })
    }

    internal fun getData() : LiveData<ArrayList<Data>>{
        return listUser
    }
}