package com.hardskygames.kinopoiskcity.ui.detail

import android.os.Bundle
import com.hardskygames.kinopoiskcity.R
import com.hardskygames.kinopoiskcity.ui.BaseActivity

class DetailActivity : BaseActivity() {
    override fun getModules(): MutableList<Any> {
        return mutableListOf(DetailActivityModule(this))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
    }
}
