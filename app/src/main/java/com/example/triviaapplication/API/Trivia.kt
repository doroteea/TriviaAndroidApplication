package com.example.triviaapplication.API

import java.io.Serializable
import java.sql.Timestamp

data class Trivia(val question: String,
                  val answer: String,
                  val value: Int,
                  val created_at: Timestamp,
                  val category: Category): Serializable {

}