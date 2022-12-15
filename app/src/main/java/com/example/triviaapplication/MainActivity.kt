package com.example.triviaapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val downloadButton = findViewById<Button>(R.id.downloadButtonId)

        downloadButton.setOnClickListener(this);
    }

    override fun onClick(p0: View?) {
        val questionNoTF = findViewById<EditText>(R.id.questionNoId)
        val errorMessage = findViewById<TextView>(R.id.errorMessaageId)

        val questionString = questionNoTF.getText().toString()

        val questionNumber = questionString.toInt()

        if (questionNumber in 1..100){
            showGIF()
            Handler().postDelayed(Runnable {
                clearGif()
            }, 4000)
        } else {
            errorMessage.text = "Question number should be between 1 and 100"
        }

    }

    fun showGIF() {
        val imageView: ImageView = findViewById(R.id.loadingGif1)
        Glide.with(this).load(R.drawable.loading2).into(imageView)
    }

    fun clearGif() {
        val imageView: ImageView = findViewById(R.id.loadingGif1)
        Glide.with(this).clear(imageView)
    }
}

