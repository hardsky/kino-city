package com.hardskygames.kinopoiskcity.service

import com.hardskygames.kinopoiskcity.entity.Movie
import rx.Observable
import java.util.*

/**
 * @author Nikolay Mihailov <hardsky@yandex.ru>  on 13.10.16.
 */

class KinoServiceStub : IKinoService {
    override fun getMoviesByDate(date: Date): Observable<List<Movie>> {
        return Observable.from(Arrays.asList(
                Movie(1, "Test", 7.5f, "test test1", "https://st.kp.yandex.net/images/sm_film/910536.jpg"),
                Movie(2, "Test", 7.5f, "test test1", "https://st.kp.yandex.net/images/sm_film/910536.jpg")))
                .toList()
    }
}