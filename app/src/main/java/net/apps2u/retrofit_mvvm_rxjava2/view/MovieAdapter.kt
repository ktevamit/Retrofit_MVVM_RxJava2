package net.apps2u.retrofit_mvvm_rxjava2.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import net.apps2u.retrofit_mvvm_rxjava2.R
import net.apps2u.retrofit_mvvm_rxjava2.model.MovieModel

class MovieAdapter(private val movieList: ArrayList<MovieModel>):
    RecyclerView.Adapter<MovieViewHolder>() {

    fun updateMovieList(newUpdateMovie: List<MovieModel>){
        movieList.clear()
        movieList.addAll(newUpdateMovie)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.movie_item,parent,false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.inx.text = movieList[position].inx.toString()
        holder.title.text = movieList[position].title
        holder.cover.text = movieList[position].cover
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}

class MovieViewHolder(view:View) : RecyclerView.ViewHolder(view){
    val inx: TextView = view.findViewById(R.id.inx_textView)
    val title: TextView = view.findViewById(R.id.title_textView)
    val cover: TextView = view.findViewById(R.id.cover_textView)
}