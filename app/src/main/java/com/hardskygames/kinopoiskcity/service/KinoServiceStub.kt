package com.hardskygames.kinopoiskcity.service

import com.hardskygames.kinopoiskcity.entity.Movie
import com.hardskygames.kinopoiskcity.entity.MovieDetails
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

    override fun getMovieDetails(id: Int): Observable<MovieDetails> {
        return Observable.just(MovieDetails(1,
                "Дом странных детей Мисс Перегрин",
                7.5f,
                "фэнтези, драма, приключения",
                "https://st.kp.yandex.net/images/sm_film/648440.jpg",
                "Детство Джейкоба прошло под рассказы дедушки о приюте для необычных детей. Среди его обитателей девочка, которая умела держать в руках огонь, девочка, чьи ноги не касались земли, невидимый мальчик и близнецы, умевшие общаться без слов. Когда дедушка умирает, 16-летний Джейкоб получает загадочное письмо и отправляется на остров, где вырос его дед. Там он находит детей, которых раньше видел только на фотографиях.",
                "США, Великобритания, Бельгия",
                2016,
                "2:07",
                "06.10.2016",
                "Тим Бёртон",
                "Ева Грин, Эйса Баттерфилд, Сэмюэл Л. Джексон, Джуди Денч, Руперт Эверетт, Эллисон Дженни, Крис О’Дауд, Теренс Стэмп, Элла Пернелл, Финлэй МакМиллан"))
    }
}