package com.aman.jokesapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_fetch.view.*
import kotlinx.android.synthetic.main.row.view.*

class JokesAdapter
    (var jokes:List<Jokes>)
    : RecyclerView.Adapter<JokesAdapter.JokesViewHolder> (){

    inner class JokesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row,parent, false)
        return JokesViewHolder(view)
    }

    override fun onBindViewHolder(holder:JokesViewHolder, position: Int) {
        holder.itemView.apply{
            itemBody.text=(jokes[position].setup+"\n"+jokes[position].punchline)
        }
    }

    override fun getItemCount(): Int {
        return jokes.size
    }
}