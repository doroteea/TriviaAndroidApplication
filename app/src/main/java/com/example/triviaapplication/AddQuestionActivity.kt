package com.example.triviaapplication

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
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

                Log.d("HERE","before checking")
                val categories = ArrayList<String>()
                categories.add("Music")
                categories.add("Geography")
                categories.add("History")
                categories.add("Personalities")

                errorMessageQuestion.text = " "
                errorMessageAnswer.text = " "
                errorMessageValue.text = " "
                errorMessageCategory.text = " "

                var hasErrors = false

                Log.d("Q",addQuestionTF.getText().toString())
                Log.d("Q",addQuestionTF.getText().toString().length.toString())
                if(addQuestionTF.getText().toString() == "" || addQuestionTF.getText().toString().length <= 5) {
                    errorMessageQuestion.text = "Question should have more than 5 letters"
                    hasErrors = true
                }
                if(addAnswerTF.getText().toString() == "" || addAnswerTF.getText().toString().length <= 5) {
                    errorMessageAnswer.text = "Answer should have more than 5 letters"
                    hasErrors = true
                }
                if(addValueTF.getText().toString() == "" || addValueTF.getText().toString().toInt() <50 || addValueTF.getText().toString().toInt()>150 ) {
                    errorMessageValue.text =  "Value should be between 50 and 150"
                    hasErrors = true
                }
                if(addCategoryTF.getText().toString() == "" || !categories.contains(addCategoryTF.getText().toString())) {
                    errorMessageCategory.text = "Accepted Categories: Music, Geography, History, Personalities"
                    hasErrors = true
                }
//                if(hasErrors){
//                    val intent = Intent(this, MainActivity::class.java)
//                    startActivity(intent)
//                }
            }
            .setNegativeButton("NO") { dialog: DialogInterface?, whichButton: Int ->
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        builder.create().show()

    }

    fun isInteger(str: String?) = str?.toIntOrNull()?.let { true } ?: false
}