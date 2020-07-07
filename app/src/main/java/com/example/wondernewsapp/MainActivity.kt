package com.example.wondernewsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val img1 = findViewById<ImageView>(R.id.imageView1)
        val btnStart = findViewById<Button>(R.id.buttonFront)

        Glide
            .with(this)
            .load("https://i.pinimg.com/originals/10/20/bf/1020bfe0f639f7206ad6cfba7176179e.png")
            .into(img1)

        btnStart.setOnClickListener {
            val intentStart = Intent(this, MainActivity2::class.java)
            startActivity(intentStart)
        }


    }
}