package com.adrian.consumerapp

import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.adrian.consumerapp.database.DatabaseContract.NoteColums.Companion.CONTENT_URI
import com.bumptech.glide.Glide
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import kotlinx.android.synthetic.main.activity_detail.*
import org.json.JSONObject

class DetailActivity : AppCompatActivity() {

    private var isFavorite = false
    private lateinit var uriWithId: Uri
    private var detail : Data? = null

    companion object{
        const val DETAIL_DATA = "DETAIL_DATA"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

//        detail = intent.getParcelableExtra(DETAIL_DATA) as Data
////
////        val username : String = detail?.name.toString()
////        val image : String = detail?.image.toString()
////        val id = detail?.id
////
////        view_pager.adapter = FragmentAdapter(this, supportFragmentManager)
////        tabs.setupWithViewPager(view_pager)
////
////        uriWithId = Uri.parse("$CONTENT_URI/$id")
////
////        showLoad(true)
////        getDetailData(username)
    }


//    private fun getDetailData(username : String){
//        val client = AsyncHttpClient()
//        client.addHeader("Author", "token e457ac400f4889b413a7b26f25050f0bbfce0e26")
//        client.addHeader("User-agent", "req")
//        val url = "https://api.github.com/users/$username"
//
//        client.get(url, object : AsyncHttpResponseHandler(){
//            override fun onSuccess(statusCode: Int, headers: Array<out Header>, responseBody: ByteArray) {
//                try {
//                    val result = String(responseBody)
//                    val responseObject = JSONObject(result)
//                    val nameDetail = responseObject.getString("name")
//                    val bioDetail = responseObject.getString("bio")
//                    val companyDetail = responseObject.getString("company")
//                    val locationDetail = responseObject.getString("location")
//                    val imageDetail = responseObject.getString("avatar_url")
//
//                    showLoad(false)
//                    name_detail.text = nameDetail
//                    bio.text = bioDetail
//                    company.text = companyDetail
//                    location.text = locationDetail
//                    Glide.with(this@DetailActivity)
//                        .load(imageDetail)
//                        .dontAnimate()
//                        .into(image_detail)
//
//                } catch (ex : Exception){
//                    Toast.makeText(this@DetailActivity, "Failed", Toast.LENGTH_LONG).show()
//                }
//            }
//            override fun onFailure(statusCode: Int, headers: Array<out Header>?, responseBody: ByteArray?, error: Throwable?) {
//                Toast.makeText(this@DetailActivity, "Failed", Toast.LENGTH_LONG).show()
//            }
//        })
//    }
//
//    private fun showLoad(state : Boolean){
//        if (state){
//            progress_bar.visibility = View.VISIBLE
//        } else {
//            progress_bar.visibility = View.INVISIBLE
//        }
//    }
}