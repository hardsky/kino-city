package com.hardskygames.kinocity.ui.main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.hardskygames.kinocity.BuildConfig
import com.hardskygames.kinocity.R
import com.hardskygames.kinocity.entity.Movie
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import org.greenrobot.eventbus.EventBus
import timber.log.Timber
import java.util.*
import javax.inject.Inject

/**
 * @author Nikolay Mihailov <hardsky@yandex.ru>  on 13.10.16.
 */

const val FILM_TYPE: Int = 1
const val ADV_TYPE: Int = 2

class FilmListAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    @Inject
    lateinit var bus: EventBus

    val filmList: MutableList<Movie> = ArrayList()
    var filtered: MutableList<Movie>? = null

    val rnd = Random(Date().time)
    var advItemPos = -1

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is FillListViewHolder) {
            val data = (filtered ?: filmList)
            Timber.d("Bind FillListViewHolder, pos = $position, arr len = ${data.size} ")

            if(data.isEmpty())
                return

            holder.setData(data[if (position > advItemPos) position - 1 else position])
        }
        else if(holder is AdvViewHolder){
            Timber.d("Bind AdvViewHolder, pos = $position, recycler item count = $itemCount")
            holder.bindAdv()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        val inflater = parent!!.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        if(viewType == FILM_TYPE) {
            return FillListViewHolder(bus, inflater.inflate(R.layout.film_item, parent, false))
        }
        else{
            return AdvViewHolder(inflater.inflate(R.layout.film_item_adv, parent, false))
        }
    }

    override fun getItemCount(): Int {
        return (filtered ?: filmList).size + 1
    }

    override fun getItemViewType(position: Int): Int {
        return when(position){
            advItemPos -> ADV_TYPE
            else -> FILM_TYPE
        }
    }

    fun setData(lst: List<Movie>) {
        filmList.clear()
        filmList.addAll(lst)
        filtered = null
        // we determine item types on data setting step
        advItemPos = rnd.nextInt(filmList.size + 1)

        notifyDataSetChanged()
    }

    fun sort(sort: RatingSortState) {
        when(sort){
            RatingSortState.NONE -> (filtered ?: filmList).sortBy(Movie::id)
            RatingSortState.DESCENDING -> (filtered ?: filmList).sortByDescending(Movie::rating)
            RatingSortState.ASCENDING -> (filtered ?: filmList).sortBy(Movie::rating)
        }

        notifyDataSetChanged()
    }

    fun filter(genre: String) {
        if(genre == "все") {
            filtered = null
            advItemPos = -1
            if(!filmList.isEmpty()) {
                advItemPos = rnd.nextInt(filmList.size + 1)
            }
        }
        else {
            advItemPos = -1
            filtered = filmList.filter { movie -> movie.genre.contains(genre) } as MutableList<Movie>
            filtered?.let{
                if(!filtered!!.isEmpty()){
                    advItemPos = rnd.nextInt(filmList.size + 1)
                }
            }
        }

        notifyDataSetChanged()
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

class AdvViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val layout: View
    val advView: AdView

    var advBuilder = AdRequest.Builder()

    init{


        layout = itemView
        advView = itemView.findViewById(R.id.advView) as AdView

        if (BuildConfig.DEBUG){
            advBuilder = advBuilder.addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
        }
    }

    fun bindAdv(){
        advView.loadAd(advBuilder.build())
    }
}

enum class RatingSortState {
    NONE,
    DESCENDING,
    ASCENDING
}