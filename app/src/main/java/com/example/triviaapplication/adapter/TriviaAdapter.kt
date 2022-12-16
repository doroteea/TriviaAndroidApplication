package com.example.triviaapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.triviaapplication.API.Trivia
import com.example.triviaapplication.R

class TriviaAdapter (
    private val context: Context,
    private val dataSource: ArrayList<Trivia>) : RecyclerView.Adapter<TriviaViewHolder>()
    {
        // similar to the ListView adapter we will define here a LayoutInflater that we
        // will use when transforming the XML to Kotlin objects for a specific list element
        private val inflater: LayoutInflater
                = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TriviaViewHolder {
            // interpret the XML file and create Kotlin internal structure
            val view = inflater.inflate ( viewType, parent, false )
            // returns the view holder which has been created from the view
            return TriviaViewHolder ( view )
        }

        override fun onBindViewHolder(holder: TriviaViewHolder, position: Int) {
            // binds the view holder with the data
            holder.bindData ( dataSource.get(position) )
        }

        override fun getItemViewType ( position: Int ) : Int {
            return R.layout.trivia_element
        }

        override fun getItemCount(): Int {
            return dataSource.size
        }
    }