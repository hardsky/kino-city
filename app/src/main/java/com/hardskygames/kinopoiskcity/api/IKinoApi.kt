package com.hardskygames.kinopoiskcity.api

import com.hardskygames.kinopoiskcity.api.response.GetFilmResponse
import com.hardskygames.kinopoiskcity.api.response.GetSeanceResponse
import com.hardskygames.kinopoiskcity.api.response.GetTodayFilmsResponse
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

/**
 * @author Nikolay Mihailov <hardsky@yandex.ru>  on 13.10.16.
 */
interface IKinoApi {

    @GET("/getTodayFilms")
    fun getTodayFilms(@Query("cityID") cityId: Int, @Query("date") date: String): Observable<GetTodayFilmsResponse>

    @GET("/getFilm")
    fun getFilm(@Query("filmID") filmId: Int): Observable<GetFilmResponse>

    @GET("/getSeance")
    fun getSeance(@Query("filmID") filmId: Int, @Query("cityID") cityId: Int, @Query("date") date: String): Observable<GetSeanceResponse>

}