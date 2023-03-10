package com.example.triviaapplication

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.triviaapplication.API.Trivia
import com.example.triviaapplication.API.TriviaAPI
import com.example.triviaapplication.adapter.TriviaAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


open class MainActivity : AppCompatActivity(), View.OnClickListener{

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

        errorMessage.text = ""

        if (questionNumber in 1..100){
            showGIF()
            Handler().postDelayed(Runnable {
                clearGif()
                displayTrivias(questionNumber)
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

    fun displayTrivias( questionNumber:Int){

        val retrofit = Retrofit.Builder()
            .baseUrl ( "http://jservice.io/api/" )
            .addConverterFactory ( GsonConverterFactory.create() )
            .build();

        val triviaApi = retrofit.create ( TriviaAPI::class.java )

        triviaApi.getTrivias ( questionNumber ).enqueue( object: Callback<List<Trivia>>
        {

            override fun onResponse (call: Call<List<Trivia>>, response: Response<List<Trivia>>)
            { Log.d("Q",questionNumber.toString())
                Log.d("GET",response.body().toString())
                triviaList.addAll( response.body() as ArrayList<Trivia>)
//                val triviaList: ArrayList<Trivia>  = response.body() as ArrayList<Trivia>
                val linearLayoutManager = LinearLayoutManager(this@MainActivity)

                val adapter = TriviaAdapter(this@MainActivity, triviaList)

                val recyclerView = findViewById<RecyclerView>(R.id.triviaRecyclerViewId)
                recyclerView.layoutManager = linearLayoutManager
                recyclerView.adapter = adapter
                Log.d("TEST",triviaList.get(0).category.title)
            }
            override fun onFailure( call: Call<List<Trivia>>, t: Throwable )
            {
                // code to be executed on connection or processing failure
            }

        });
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.options_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.item1Id -> startActivity(Intent(this, AddQuestionActivity::class.java))
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            if (data != null) {
                if (data.hasExtra("Q")) {
                    Log.d("PLS",""+data.getExtras()!!.getString("Q"))
                    Toast.makeText(
                        this, data.extras!!.getString("Q"),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }


}

