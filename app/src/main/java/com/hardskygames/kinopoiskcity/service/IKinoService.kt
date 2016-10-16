package com.hardskygames.kinopoiskcity.service

import com.hardskygames.kinopoiskcity.entity.Movie
import com.hardskygames.kinopoiskcity.entity.MovieDetails
import com.hardskygames.kinopoiskcity.entity.Seance
import rx.Observable
import java.util.*

/**
 * @author Nikolay Mihailov <hardsky@yandex.ru>  on 13.10.16.
 */

interface IKinoService{
    fun getMoviesByDate(date: Date): Observable<List<Movie>>
    fun getMovieDetails(id: Int): Observable<MovieDetails>
    fun getSeances(movieId: Int, date: Date): Observable<List<Seance>>
}