package com.hardskygames.kinocity

import com.hardskygames.kinocity.entity.City
import com.hardskygames.kinocity.service.IKinoService
import com.hardskygames.kinocity.service.KinoServiceStub
import dagger.Module
import dagger.Provides
import org.greenrobot.eventbus.EventBus
import java.util.*
import javax.inject.Singleton

/**
* @author Nikolay Mihailov <hardsky@yandex.ru>  on 27.09.15.
*/
@Module(injects = arrayOf(
        KinoApp::class),
        library = true)
class AppModule(private val application: KinoApp) {

    @Provides
    @Singleton
    internal fun provideAppBus(): EventBus {
        return EventBus.builder().logNoSubscriberMessages(false).sendNoSubscriberEvent(false).build()
    }

    @Provides
    @Singleton
    internal fun provideService(city: City): IKinoService {
        //return KinoService(city)
        return KinoServiceStub()
        //return KinoServiceErrorStub()
    }


    @Provides
    @Singleton
    internal fun provideCity(): City {
        return City()
    }

    @Provides
    @Singleton
    internal fun provideDate(): Date {
        return Date()
    }

}
