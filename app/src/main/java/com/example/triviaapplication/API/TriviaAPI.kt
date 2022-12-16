package com.example.triviaapplication.API

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*


public interface TriviaAPI {
    @GET("random")
    @Headers("Content-Type: application/json")
    fun getTrivias(@Query("count") count: Int): Call<List<Trivia>>

    fun getTriviaAPI(): TriviaAPI? {
        val retrofit = Retrofit.Builder()
        .baseUrl ( "http://jservice.io/api/random" )
        .addConverterFactory ( GsonConverterFactory.create() )
        .build();
        return retrofit.create(TriviaAPI::class.java)
    }

    fun httInterceptor(): HttpLoggingInterceptor? {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return interceptor
    }

    fun getClient(): OkHttpClient? {
        return httInterceptor()?.let {
            OkHttpClient.Builder()
                .addInterceptor(it)
                .build()
        }
    }
}