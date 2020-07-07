package com.example.wondernewsapp

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.news_card.*
import kotlinx.android.synthetic.main.news_card.view.*
import org.json.JSONArray
import org.json.JSONObject

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val listV = findViewById<ListView>(R.id.listViewMain2)
        val url = "https://newsapi.org/v2/top-headlines?country=in&category=business&apiKey=15394f4dee0444bb8df98cfa94bd1166"

        val queue = Volley.newRequestQueue(this)
        val jo = JsonObjectRequest(Request.Method.GET, url, null,
        Response.Listener { response ->
            val jArr = response.getJSONArray("articles")
            listV.adapter = NewsAdapter(this, jArr)
        },
        Response.ErrorListener {
            Log.i("lolipop", "error")
        })
        queue.add(jo)


    }

    inner class NewsAdapter(context :Context, arr :JSONArray) :BaseAdapter(){

        val newArr = arr
        val mContext = context

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val news = newArr[p0] as JSONObject
            val inflater = mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val cardView = inflater.inflate(R.layout.news_card, null, true)
            val title = news.getString("title")
            val imgpath = news.get("urlToImage").toString()
            Glide.with(mContext)
                .load(imgpath)
                .into(cardView.imageViewNewsCard)

            cardView.textViewNewsCard.text = title
            return cardView
        }

        override fun getItem(p0: Int): Any {
            return newArr[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getCount(): Int {
            return newArr.length()
        }


    }

}