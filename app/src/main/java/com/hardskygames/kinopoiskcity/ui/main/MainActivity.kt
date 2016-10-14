package com.hardskygames.kinopoiskcity.ui.main

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.hardskygames.kinopoiskcity.R
import com.hardskygames.kinopoiskcity.entity.Movie
import com.hardskygames.kinopoiskcity.service.IKinoService
import com.hardskygames.kinopoiskcity.ui.BaseActivity
import com.hardskygames.kinopoiskcity.ui.detail.DetailActivity
import com.hardskygames.kinopoiskcity.ui.detail.MOVIE_ID_PARAM
import kotlinx.android.synthetic.main.activity_main.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import rx.subjects.BehaviorSubject
import java.util.*
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var service: IKinoService
    @Inject
    lateinit var adapter: FilmListAdapter
    @Inject
    lateinit var bus: EventBus

    private val subj = BehaviorSubject.create<List<Movie>>()
    lateinit private var subs: Subscription

    override fun getModules(): MutableList<Any> {
        return mutableListOf(MainActivityModule(this))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lstMovies.layoutManager = LinearLayoutManager(this)
        lstMovies.adapter = adapter

        service.getMoviesByDate(Date()).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(subj)
    }

    override fun onResume() {
        super.onResume()

        bus.register(this)
        subs = subj.subscribe{lst -> adapter.setData(lst); adapter.notifyDataSetChanged()}
    }

    override fun onPause() {
        subs.unsubscribe()
        bus.unregister(this)

        super.onPause()
    }

    @Subscribe
    fun onMovieClickEvent(ev: MovieClickEvent){
        startActivity(Intent(this, DetailActivity::class.java).putExtra(MOVIE_ID_PARAM, ev.id))
    }
}
