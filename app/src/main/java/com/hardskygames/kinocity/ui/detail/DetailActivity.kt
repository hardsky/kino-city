package com.hardskygames.kinocity.ui.detail

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.hardskygames.kinocity.R
import com.hardskygames.kinocity.entity.MovieDetails
import com.hardskygames.kinocity.service.IKinoService
import com.hardskygames.kinocity.ui.BaseActivity
import com.hardskygames.kinocity.ui.schedule.ScheduleActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import rx.subjects.BehaviorSubject
import timber.log.Timber
import javax.inject.Inject

const val MOVIE_ID_PARAM = "MOVIE_ID_PARAM"

class DetailActivity() : BaseActivity() {
    @Inject
    lateinit var service: IKinoService

    private val subj = BehaviorSubject.create<MovieDetails>()
    lateinit private var subs: Subscription


    override val modules: List<Any> = listOf(DetailActivityModule(this))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
    }

    override fun onResume() {
        super.onResume()

        val id = intent.getIntExtra(MOVIE_ID_PARAM, 0)
        service.getMovieDetails(id).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(subj)

        subs = subj.subscribe({movie ->
            txtTitle.text = movie.name
            Picasso.with(this).load(movie.posterUrl).into(imgPoster)
            txtYear.text = "${movie.year}г."
            txtGenre.text = movie.genre
            txtRating.text = movie.rating.toString()
            txtDescription.text = movie.description
        },{t ->
            Timber.e(t, "Error on movies request.")
            Toast.makeText(this@DetailActivity, R.string.err_service, Toast.LENGTH_LONG).show()
        })

        btnSchedule.setOnClickListener { startActivity(Intent(this, ScheduleActivity::class.java).
                putExtra(com.hardskygames.kinocity.ui.schedule.MOVIE_ID_PARAM, id)) }
    }
}
