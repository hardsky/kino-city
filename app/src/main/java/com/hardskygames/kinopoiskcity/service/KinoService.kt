package com.hardskygames.kinopoiskcity.service

import com.hardskygames.kinopoiskcity.api.IKinoApi
import com.hardskygames.kinopoiskcity.api.response.TodayFilm
import com.hardskygames.kinopoiskcity.entity.City
import com.hardskygames.kinopoiskcity.entity.Movie
import com.hardskygames.kinopoiskcity.entity.MovieDetails
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.jackson.JacksonConverterFactory
import rx.Observable
import java.util.*

/**
 * @author Nikolay Mihailov <hardsky@yandex.ru>  on 13.10.16.
 */
class KinoService(private val city: City): IKinoService {

    private val api: IKinoApi

    init {
        val retrofit = Retrofit.
                Builder().
                baseUrl("http://api.kinopoisk.cf").
                addCallAdapterFactory(RxJavaCallAdapterFactory.create()).
                addConverterFactory(JacksonConverterFactory.create()).
                build()

        api = retrofit.create(IKinoApi::class.java)
    }

    override fun getMoviesByDate(date: Date): Observable<List<Movie>> {
        return api.getTodayFilms(city.id, String.format("dd.MM.yyyy", date)).
                flatMap { resp -> Observable.from(resp.films) }.
                map{film -> TodayFilmToMoview(film)}.
                toList()
    }

    override fun getMovieDetails(id: Int): Observable<MovieDetails> {

        return api.getFilm(id).
                map{resp -> MovieDetails(resp.filmID,
                        resp.nameRU!!,
                        (resp.ratingData?.ratingIMDb ?: 0.0).toFloat(),
                        resp.genre!!,
                        "https://st.kp.yandex.net/images/film_big/${resp.filmID}.jpg",
                        resp.description ?: "",
                        resp.country ?: "",
                        resp.year,
                        resp.filmLength ?: "",
                        resp.rentData?.premiereRU ?: "",
                        "",//TODO:
                        "")
                }
    }

}

fun TodayFilmToMoview(film: TodayFilm?): Movie{
    return Movie(film!!.id, film.nameRU!!, film.rating!!.split(" ")[0].toFloat(), film.genre!!,
            "https://st.kp.yandex.net/images/sm_film/${film.id}.jpg")
}
