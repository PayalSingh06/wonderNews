package com.example.wondernewsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val bundle = intent.extras
        val img = bundle!!.getInt("image")
        val name = bundle.getString("name")
        val imgView = findViewById<ImageView>(R.id.imageViewMain3)
        val  txtView = findViewById<TextView>(R.id.textViewMain3)
        imgView.setImageResource(img)
        txtView.text = name

    }
}