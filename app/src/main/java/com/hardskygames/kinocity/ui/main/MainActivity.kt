package com.hardskygames.kinocity.ui.main

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.google.android.gms.ads.AdRequest
import com.hardskygames.kinocity.R
import com.hardskygames.kinocity.entity.Movie
import com.hardskygames.kinocity.service.IKinoService
import com.hardskygames.kinocity.ui.BaseActivity
import com.hardskygames.kinocity.ui.detail.DetailActivity
import com.hardskygames.kinocity.ui.detail.MOVIE_ID_PARAM
import kotlinx.android.synthetic.main.activity_main.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import rx.subjects.BehaviorSubject
import timber.log.Timber
import java.util.*
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var service: IKinoService
    @Inject
    lateinit var adapter: FilmListAdapter
    @Inject
    lateinit var bus: EventBus
    @Inject
    lateinit var movieDate: Date

    private val subj = BehaviorSubject.create<List<Movie>>()
    lateinit private var subs: Subscription

    override val modules: List<Any> = listOf(MainActivityModule(this))

    private var sort = RatingSortState.NONE
    private var genre = "все"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        lstMovies.layoutManager = LinearLayoutManager(this)
        lstMovies.adapter = adapter

        val spinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.genres, android.R.layout.simple_spinner_item)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinRating.adapter = spinnerAdapter
        spinRating.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                genre = parent.getItemAtPosition(position) as String
                adapter.filter(genre)
                adapter.notifyDataSetChanged()
            }
        }

        val dates = ArrayList<String>(6)
        for (i in 0..5){
            val calendar = Calendar.getInstance()
            calendar.add(Calendar.DAY_OF_YEAR, i)
            dates.add(String.format("%1\$td.%1\$tm.%1\$tY", calendar.time))
        }
        val dateAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, dates)
        dateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinDate.adapter = dateAdapter
        spinDate.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {

                val calendar = Calendar.getInstance()
                calendar.add(Calendar.DAY_OF_YEAR, position)
                movieDate.time = calendar.time.time

                sort = RatingSortState.NONE
                genre = "все"

                service.getMoviesByDate(movieDate).
                        subscribeOn(Schedulers.io()).
                        observeOn(AndroidSchedulers.mainThread()).
                        subscribe({ v -> subj.onNext(v) },
                                { t ->
                                    Timber.e(t, "Error on movies request.")
                                    Toast.makeText(this@MainActivity, R.string.err_service, Toast.LENGTH_LONG).show()
                                })

            }
        }

        val adRequest = AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build()
        advView.loadAd(adRequest)
    }

    override fun onResume() {
        super.onResume()

        bus.register(this)
        subs = subj.subscribe{lst -> adapter.setData(lst); adapter.notifyDataSetChanged()}

        btnSort.setOnClickListener {
            sort = when(sort){
                RatingSortState.NONE -> RatingSortState.DESCENDING
                RatingSortState.DESCENDING -> RatingSortState.ASCENDING
                RatingSortState.ASCENDING -> RatingSortState.NONE
            }
            adapter.sort(sort)
            adapter.notifyDataSetChanged()
        }
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
