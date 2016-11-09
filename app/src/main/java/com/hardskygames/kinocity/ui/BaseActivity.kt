package com.hardskygames.kinocity.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

import com.hardskygames.kinocity.KinoApp

import dagger.ObjectGraph

/**
 * @author Nikolay Mihailov @yandex.ru>  on 11.05.16.
 */
abstract class BaseActivity : AppCompatActivity() {
    private var activityGraph: ObjectGraph? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Create the activity graph by .plus-ing our modules onto the application graph.
        val application = application as KinoApp
        activityGraph = application.applicationGraph.plus(*modules.toTypedArray())

        // Inject ourselves so subclasses will have dependencies fulfilled when this method returns.
        activityGraph!!.inject(this)
    }


    override fun onDestroy() {
        // Eagerly clear the reference to the activity graph to allow it to be garbage collected as
        // soon as possible.
        activityGraph = null
        super.onDestroy()
    }

    /**
     * A list of modules to use for the individual activity graph. Subclasses can override this
     * method to provide additional modules provided they call and include the modules returned by
     * calling `super.getModules()`.
     */
    protected abstract val modules: List<Any>

    /**
     * Inject the supplied `object` using the activity-specific graph.
     */
    fun inject(`object`: Any) {
        activityGraph!!.inject(`object`)
    }
}
