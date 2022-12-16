package com.example.triviaapplication

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.triviaapplication.API.Trivia
import com.example.triviaapplication.API.TriviaAPI
import com.example.triviaapplication.adapter.TriviaAdapter
import okhttp3.OkHttpClient

class MainActivity : AppCompatActivity(), View.OnClickListener{

    private val triviaList: ArrayList<Trivia> = java.util.ArrayList();

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
                displayTrivias()
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

    fun displayTrivias(){
        val linearLayoutManager = LinearLayoutManager(this)
        val adapter = TriviaAdapter(this, triviaList)

        val recyclerView = findViewById<RecyclerView>(R.id.triviaRecyclerViewId)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = adapter

//        val trivia_api = getTriviaAPI()

//        val message: String = sendMessage.getText().toString()
//        val newChatMessage =
//            ChatMessage(getDisplayName(), message, Timestamp(System.currentTimeMillis()), false)
//        triviaList.add(newChatMessage)
//        val responseMessage = ChatMessage(
//            "Computer",
//            "Automated response",
//            Timestamp(System.currentTimeMillis()),
//            false
//        )
//        chatMessagesList.add(responseMessage)

    }
}

