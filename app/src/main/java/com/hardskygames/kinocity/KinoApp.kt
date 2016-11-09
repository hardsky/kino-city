package com.hardskygames.kinocity

import android.app.Application
import android.util.Log
import dagger.ObjectGraph
import timber.log.Timber
import java.util.*

/**
* @author Nikolay Mihailov <hardsky@yandex.ru>  on 10.05.16.
*/
class KinoApp : Application() {

    lateinit var applicationGraph: ObjectGraph
        private set


    override fun onCreate() {
        super.onCreate()

        applicationGraph = ObjectGraph.create(*modules.toTypedArray())
        applicationGraph.inject(this)

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        else{
            Timber.plant(CrashReportingTree())
        }
    }

    /**
     * A list of modules to use for the application graph. Subclasses can override this method to
     * provide additional modules provided they call `super.getModules()`.
     */
    private val modules: List<Any>
        get() = Arrays.asList<Any>(AppModule(this))

    private inner class CrashReportingTree : Timber.Tree() {
        override fun log(priority: Int, tag: String?, message: String?, t: Throwable?) {
            if (priority != Log.ERROR) {
                return
            }

            Log.e(tag, message, t)
        }
    }
}
