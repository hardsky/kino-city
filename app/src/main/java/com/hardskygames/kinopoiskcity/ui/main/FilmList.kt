package com.hardskygames.kinopoiskcity.ui.main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.hardskygames.kinopoiskcity.R
import com.hardskygames.kinopoiskcity.entity.Movie
import com.squareup.picasso.Picasso
import org.greenrobot.eventbus.EventBus
import java.util.*
import javax.inject.Inject

/**
 * @author Nikolay Mihailov <hardsky@yandex.ru>  on 13.10.16.
 */

class FilmListAdapter: RecyclerView.Adapter<FillListViewHolder>() {

    @Inject
    lateinit var bus: EventBus

    val filmList: MutableList<Movie> = ArrayList()
    var filtered: MutableList<Movie>? = null

    override fun onBindViewHolder(holder: FillListViewHolder, position: Int) {
        holder.setData((filtered ?: filmList)[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): FillListViewHolder {
        val inflater = parent!!.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        return FillListViewHolder(bus, inflater.inflate(R.layout.film_item, null))
    }

    override fun getItemCount(): Int {
        return (filtered ?: filmList).size
    }

    fun setData(lst: List<Movie>) {
        filmList.clear()
        filmList.addAll(lst)
        filtered = null
    }

    fun sort(sort: RatingSortState) {
        when(sort){
            RatingSortState.NONE -> (filtered ?: filmList).sortBy(Movie::id)
            RatingSortState.DESCENDING -> (filtered ?: filmList).sortByDescending(Movie::rating)
            RatingSortState.ASCENDING -> (filtered ?: filmList).sortBy(Movie::rating)
        }
    }

    fun filter(genre: String) {
        if(genre == "все") {
            filtered = null
        }
        else {
            filtered = filmList.filter { movie -> movie.genre.contains(genre) } as MutableList<Movie>
        }
    }
}

class FillListViewHolder(private val bus: EventBus, itemView: View) : RecyclerView.ViewHolder(itemView) {
    val layout: View
    val imgPoster: ImageView
    val txtTitle: TextView
    val txtGenre: TextView
    val txtRating: TextView
    val context: Context

    init{
        layout = itemView
        imgPoster = itemView.findViewById(R.id.imgPoster) as ImageView
        txtTitle = itemView.findViewById(R.id.txtTitle) as TextView
        txtGenre = itemView.findViewById(R.id.txtGenre) as TextView
        txtRating = itemView.findViewById(R.id.txtRating) as TextView
        context = itemView.context
    }

    fun setData(movie: Movie){
        Picasso.with(context).load(movie.posterUrl).into(imgPoster)
        txtTitle.text = movie.name
        txtGenre.text = "(${movie.genre})"
        txtRating.text = movie.rating.toString()

        layout.setOnClickListener { bus.post(MovieClickEvent(movie.id)) }
    }
}

enum class RatingSortState {
    NONE,
    DESCENDING,
    ASCENDING
}