package com.hardskygames.kinopoiskcity.ui.schedule

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.hardskygames.kinopoiskcity.R
import com.hardskygames.kinopoiskcity.entity.Seance
import com.hardskygames.kinopoiskcity.service.IKinoService
import com.hardskygames.kinopoiskcity.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_schedule.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import rx.subjects.BehaviorSubject
import java.util.*
import javax.inject.Inject

const val MOVIE_ID_PARAM = "MOVIE_ID_PARAM"

class ScheduleActivity : BaseActivity() {

    @Inject
    lateinit var service: IKinoService
    @Inject
    lateinit var bus: EventBus
    @Inject
    lateinit var adapter: SeanceListAdapter
    @Inject
    lateinit var movieDate: Date

    private val subj = BehaviorSubject.create<List<Seance>>()
    lateinit private var subs: Subscription

    override val modules: List<Any> = listOf(ScheduleActivityModule(this))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule)

        lstSeances.layoutManager = LinearLayoutManager(this)
        lstSeances.adapter = adapter
    }

    override fun onResume() {
        super.onResume()

        val movieId = intent.getIntExtra(com.hardskygames.kinopoiskcity.ui.schedule.MOVIE_ID_PARAM, 0)
        service.getSeances(movieId, movieDate).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(subj)

        bus.register(this)
        subs = subj.subscribe{lst -> adapter.setData(lst); adapter.notifyDataSetChanged()}
    }

    override fun onPause() {
        subs.unsubscribe()
        bus.unregister(this)

        super.onPause()
    }

    @Subscribe
    fun onSeanceClickEvent(ev: SeanceClickEvent){
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(String.format(Locale.US, "geo:0,0?q=%f,%f(%s)", ev.lat, ev.lon, ev.cinema))
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }
}
