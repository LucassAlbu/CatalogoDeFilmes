package com.lucassalbu.catalogodefilmessuperior.serviceApi

import com.lucassalbu.catalogodefilmessuperior.models.MovieDetailModel
import com.lucassalbu.catalogodefilmessuperior.models.MoviesModel
import com.lucassalbu.catalogodefilmessuperior.utils.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("/3/movie/popular$API_KEY&language=pt-BR")
    suspend fun getPopularMovies(): Response<MoviesModel>

    @GET("/3/movie/{movie_id}$API_KEY&language=pt-BR")
    suspend fun getMoviesDetails(
        @Path("movie_id") movieID: Int
    ): Response<MovieDetailModel>

    @GET("/3/movie/top_rated$API_KEY&language=pt-BR")
    suspend fun getTopRated(): Response<MoviesModel>

    @GET("/3//movie/{movie_id}/similar$API_KEY&language=pt-BR\"")
    suspend fun getSimilarMovies(
        @Path("movie_id") movieID: Int
    ): Response<MoviesModel>
}