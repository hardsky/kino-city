package com.hardskygames.kinopoiskcity.ui.main

import com.hardskygames.kinopoiskcity.AppModule
import dagger.Module

/**
 * @author Nikolay Mihailov <hardsky@yandex.ru>  on 13.10.16.
 */
@Module(injects = arrayOf(
        MainActivity::class,
        FilmListAdapter::class), addsTo = AppModule::class, library = true)
class MainActivityModule(val activity: MainActivity) {
}