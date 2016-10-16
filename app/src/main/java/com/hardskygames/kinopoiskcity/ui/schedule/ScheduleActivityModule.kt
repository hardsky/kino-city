package com.hardskygames.kinopoiskcity.ui.schedule

import com.hardskygames.kinopoiskcity.AppModule
import dagger.Module

/**
 * @author Nikolay Mihailov <hardsky@yandex.ru>  on 13.10.16.
 */
@Module(injects = arrayOf(
        ScheduleActivity::class,
        SeanceListAdapter::class), addsTo = AppModule::class, library = true)
class ScheduleActivityModule(val activity: ScheduleActivity) {
}