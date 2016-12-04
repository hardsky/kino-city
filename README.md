# KinoCity

### Поиск киносеансов в моём городе

Приложение на основе апи kinopoisk.cf (https://github.com/wielski/KinopoiskApi)  
Проект заморожен и выложен под открытой лицензией, т.к. апи прекратило функционировать.

показана работа:
 - с апи
 - Kotlin
 - RecyclerView
 - DI
 - картой
 - event bus

#### Сценарии работы с приложением
 * Пользователь может просмотреть список фильмов в прокате, сделать
сортировку по рейтингу и фильтр по жанру;
 * Пользователь может просмотреть подробную информацию по выбранному
фильму;
 * Пользователь может просмотреть расписание сеансов;
 * Пользователь может просмотреть карту с местоположением кинотеатра в

#### Детали реализации

Приложение разбито на отдельные модули, которые соединены через event bus,
зависимости инжектятся через DI (Dependency Injection) фреймворк.

библиотеки
 - http://square.github.io/dagger/ - DI framework
 - http://square.github.io/picasso/ - загрузка и работа с изображениями
 - http://square.github.io/retrofit/ - REST api
 - http://greenrobot.org/eventbus/ - event bus
 - https://github.com/ReactiveX/RxJava - склейка запросов к апи и логики прилоежения
 - https://github.com/JakeWharton/timber - logger
 - com.google.firebase:firebase-ads - показ рекламы