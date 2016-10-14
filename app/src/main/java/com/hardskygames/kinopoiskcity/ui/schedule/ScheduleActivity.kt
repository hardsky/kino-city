package com.hardskygames.kinopoiskcity.ui.schedule

import android.os.Bundle
import com.hardskygames.kinopoiskcity.R
import com.hardskygames.kinopoiskcity.ui.BaseActivity

class ScheduleActivity : BaseActivity() {

    override fun getModules(): MutableList<Any> {
        return mutableListOf(ScheduleActivityModule(this))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule)
    }
}
