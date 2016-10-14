package com.hardskygames.kinopoiskcity.service

import com.hardskygames.kinopoiskcity.entity.Movie
import rx.Observable
import java.util.*

/**
 * @author Nikolay Mihailov <hardsky@yandex.ru>  on 13.10.16.
 */

interface IKinoService{
    fun getMoviesByDate(date: Date): Observable<List<Movie>>
}