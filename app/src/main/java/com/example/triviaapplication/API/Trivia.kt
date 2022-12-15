package com.example.triviaapplication.API

import java.sql.Timestamp

data class Trivia(val question: String,
                  val answer: Int,
                  val value: String,
                  val created_at: Timestamp,
                  val category_title: String) {

}