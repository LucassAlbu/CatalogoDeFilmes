package com.lucassalbu.catalogodefilmessuperior.repositories

import com.lucassalbu.catalogodefilmessuperior.models.MovieDetailModel
import com.lucassalbu.catalogodefilmessuperior.models.MoviesModel
import com.lucassalbu.catalogodefilmessuperior.models.TvShowModel
import retrofit2.Response

interface Repository {
    suspend fun getPopularMovie(): Response<MoviesModel>
    suspend fun getMovieDetail(movieID: Int): Response<MovieDetailModel>
    suspend fun getTopRated(): Response<MoviesModel>
    suspend fun getSimilarMovies(movieID: Int): Response<MoviesModel>
    suspend fun getUpcomingMovies(): Response<MoviesModel>
    suspend fun getTvshows(): Response<TvShowModel>
}