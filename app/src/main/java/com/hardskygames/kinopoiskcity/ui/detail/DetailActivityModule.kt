package com.hardskygames.kinopoiskcity.ui.detail

import com.hardskygames.kinopoiskcity.AppModule
import dagger.Module

/**
 * @author Nikolay Mihailov <hardsky@yandex.ru>  on 13.10.16.
 */
@Module(injects = arrayOf(
        DetailActivity::class), addsTo = AppModule::class, library = true)
class DetailActivityModule(val activity: DetailActivity) {
}