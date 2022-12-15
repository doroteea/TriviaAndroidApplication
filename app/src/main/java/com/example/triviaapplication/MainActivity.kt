package com.example.triviaapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

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
            errorMessage.text = "OK"
        } else {
            errorMessage.text = "Question number should be between 1 and 100"
        }

    }
}