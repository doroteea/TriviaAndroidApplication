package com.example.triviaapplication.API

import java.sql.Timestamp

data class Trivia(val question: String,
                  val answer: String,
                  val value: Int,
                  val created_at: Timestamp,
                  val category_title: String) {

}