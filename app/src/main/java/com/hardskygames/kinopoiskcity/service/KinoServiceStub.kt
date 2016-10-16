package com.hardskygames.kinopoiskcity.service

import com.hardskygames.kinopoiskcity.entity.Movie
import com.hardskygames.kinopoiskcity.entity.MovieDetails
import com.hardskygames.kinopoiskcity.entity.Seance
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
                "https://st.kp.yandex.net/images/film_big/648440.jpg",
                "Детство Джейкоба прошло под рассказы дедушки о приюте для необычных детей. Среди его обитателей девочка, которая умела держать в руках огонь, девочка, чьи ноги не касались земли, невидимый мальчик и близнецы, умевшие общаться без слов. Когда дедушка умирает, 16-летний Джейкоб получает загадочное письмо и отправляется на остров, где вырос его дед. Там он находит детей, которых раньше видел только на фотографиях.",
                "США, Великобритания, Бельгия",
                2016,
                "2:07",
                "06.10.2016",
                "Тим Бёртон",
                "Ева Грин, Эйса Баттерфилд, Сэмюэл Л. Джексон, Джуди Денч, Руперт Эверетт, Эллисон Дженни, Крис О’Дауд, Теренс Стэмп, Элла Пернелл, Финлэй МакМиллан"))
    }

    override fun getSeances(movieId: Int, date: Date): Observable<List<Seance>> {
        return Observable.from(Arrays.asList(
                Seance("Киносфера", "14:30", "Челнокова, 11", 54.73764481410551, 20.485269794967625),
                Seance("Киносфера", "21:55", "Челнокова, 11", 54.73764481410551, 20.485269794967625),
                Seance("Синема Парк Европа", "14:20", "Профессора Баранова, 40", 54.71856375060162, 20.498978063415528),
                Seance("Синема Парк Европа", "21:00", "Профессора Баранова, 40", 54.71856375060162, 20.498978063415528)
        ))
                .toList()
    }
}