package com.lucassalbu.catalogodefilmessuperior.repositories

import com.lucassalbu.catalogodefilmessuperior.models.MovieDetailModel
import com.lucassalbu.catalogodefilmessuperior.models.MoviesModel
import retrofit2.Response

interface Repository {
    suspend fun getPopularMovie(): Response<MoviesModel>
    suspend fun getMovieDetail(movieID: Int): Response<MovieDetailModel>
    suspend fun getTopRated(): Response<MoviesModel>
    suspend fun getSimilarMovies(movieID: Int): Response<MoviesModel>
}