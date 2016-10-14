package com.hardskygames.kinopoiskcity.entity

/**
 * @author Nikolay Mihailov <hardsky@yandex.ru>  on 14.10.16.
 */
data class MovieDetails(val id: Int,
                        val name: String,
                        val rating: Float,
                        val genre: String,
                        val posterUrl: String,
                        val description: String,
                        val country: String,
                        val year: Int,
                        val filmLength: String,
                        val premiereDate: String,
                        val director: String,
                        val actors: String)