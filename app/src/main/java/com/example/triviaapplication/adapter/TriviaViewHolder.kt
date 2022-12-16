package com.example.triviaapplication.adapter

import android.R.attr.data
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.triviaapplication.API.Trivia
import com.example.triviaapplication.R


class TriviaViewHolder ( private val view: View) : RecyclerView.ViewHolder ( view ){
    private lateinit var questionRef: TextView
    private lateinit var answerRef: TextView
    private lateinit var valueRef: TextView
    private lateinit var createdAtRef: TextView
    private lateinit var categoryTitleRef: TextView

    init
    {
        questionRef = view.findViewById(R.id.questionId1)
        answerRef = view.findViewById(R.id.answerId1)
        valueRef = view.findViewById(R.id.valueId1)
        createdAtRef = view.findViewById(R.id.createdId1)
        categoryTitleRef = view.findViewById(R.id.titleId1)
    }
    fun bindData (data: Trivia)
    {
        questionRef.text = data.question
        answerRef.text = data.answer
        valueRef.text = data.value.toString()
        createdAtRef.text = data.created_at.toString()
        categoryTitleRef.text = data.category_title

    }

//    fun onClick(view: View?) {
//        val position = adapterPosition
//        println("Toggle star $position")
//        val visible = starRef.getVisibility() === VISIBLE
//        data.setImportant(!visible)
//        starRef.setVisibility(if (visible) INVISIBLE else VISIBLE)
//    }


}