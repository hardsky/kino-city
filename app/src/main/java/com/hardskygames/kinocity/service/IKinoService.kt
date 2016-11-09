package com.hardskygames.kinocity.service

import com.hardskygames.kinocity.entity.Movie
import com.hardskygames.kinocity.entity.MovieDetails
import com.hardskygames.kinocity.entity.Seance
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