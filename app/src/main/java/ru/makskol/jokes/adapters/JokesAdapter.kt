package ru.makskol.jokes.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.joke_item.view.*
import ru.makskol.jokes.pojo.Joke
import ru.makskol.jokes.R

class JokesAdapter: RecyclerView.Adapter<JokesAdapter.JokesHolder>() {

    var jokes: List<Joke> = ArrayList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class JokesHolder(itemView:View): RecyclerView.ViewHolder(itemView) {

        val joke: TextView = itemView.textViewJoke

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokesHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.joke_item, parent, false)
        return JokesHolder(view)

    }

    override fun getItemCount(): Int {
        return jokes.size
    }

    override fun onBindViewHolder(holder: JokesHolder, position: Int) {

        var joke = jokes[position]
        holder.joke.text = joke.joke

    }

}