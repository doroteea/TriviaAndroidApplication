package com.example.triviaapplication

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity


class AddQuestionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_question)
        val errorMessageQuestion = findViewById<TextView>(R.id.errorQuestionId)
        val errorMessageAnswer = findViewById<TextView>(R.id.errorAnswerId)
        val errorMessageValue = findViewById<TextView>(R.id.errorValueId)
        val errorMessageCategory = findViewById<TextView>(R.id.errorCategoryId)

        errorMessageQuestion.text = " "
        errorMessageAnswer.text = " "
        errorMessageValue.text = " "
        errorMessageCategory.text = " "


    }

    override fun onBackPressed() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Back")
            .setMessage("Do you want to save the question?")
            .setPositiveButton("YES") { dialog: DialogInterface?, whichButton: Int ->

                val addQuestionTF = findViewById<EditText>(R.id.questionTFId)
                val addAnswerTF = findViewById<EditText>(R.id.answerTFId)
                val addValueTF = findViewById<EditText>(R.id.valueTFId)
                val addCategoryTF = findViewById<EditText>(R.id.categoryTFId)

                val errorMessageQuestion = findViewById<TextView>(R.id.errorQuestionId)
                val errorMessageAnswer = findViewById<TextView>(R.id.errorAnswerId)
                val errorMessageValue = findViewById<TextView>(R.id.errorValueId)
                val errorMessageCategory = findViewById<TextView>(R.id.errorCategoryId)


                var hasErrors: Boolean = false

                if(addQuestionTF.getText().toString().length <= 5) {
                    errorMessageQuestion.text = "Question should have more than 5 letters"
                    hasErrors = true
                }
                if(addAnswerTF.getText().toString().length <= 5) {
                    errorMessageAnswer.text = "Answer should have more than 5 letters"
                    hasErrors = true
                }
                if(addValueTF.getText().toString().toInt() in 50..150 ) {
                    errorMessageValue.text = "Value should be between 50 and 150"
                    hasErrors = true
                }
                if(addCategoryTF.getText().toString().length <= 5) {
                    errorMessageCategory.text = "Accepted Categories: Muzică, Geografie, Istorie, Personalități"
                    hasErrors = true
                }
                if(!hasErrors){
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
            }
            .setNegativeButton("NO") { dialog: DialogInterface?, whichButton: Int ->
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        builder.create().show()

    }
}