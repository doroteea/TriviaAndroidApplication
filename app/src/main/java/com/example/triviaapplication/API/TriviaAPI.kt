package com.example.triviaapplication.API

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*


public interface TriviaAPI {
    // describe the HTTP method type (other values: @POST, @PUT, @DELETE)
    // and the path of the endpoint relative to the root address of the API
    @GET("random/")
    // set the static header that specifies the encoding of the data transfer
    // this is static information and will be the same for all the calls
    @Headers("Content-Type: application/json")
    // add information about the data mapping and return type
    fun getTrivias(@Query("count") number: Int): Call<List<Trivia>>

    @PUT ( "end_point_URL" )
    fun endPointMethod ( @Body body: Trivia ) : Call<Void>




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