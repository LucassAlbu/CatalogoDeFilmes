package com.lucassalbu.catalogodefilmessuperior.repositories

import com.lucassalbu.catalogodefilmessuperior.models.MovieDetailModel
import com.lucassalbu.catalogodefilmessuperior.models.MoviesModel
import com.lucassalbu.catalogodefilmessuperior.models.TvShowModel
import com.lucassalbu.catalogodefilmessuperior.serviceApi.ApiInterface
import retrofit2.Response
import javax.inject.Inject

class RepositoryCF @Inject  constructor(
    // private val userDataStore: DataStore<Preferences>,
    private val apiInterface: ApiInterface,
) : Repository {
    override suspend fun getPopularMovie(): Response<MoviesModel> {
        return apiInterface.getPopularMovies()
    }

    override suspend fun getMovieDetail(movieID: Int): Response<MovieDetailModel> {
        return apiInterface.getMoviesDetails(movieID)
    }

    override suspend fun getTopRated(page: Int): Response<MoviesModel> {
        return apiInterface.getTopRated(page)
    }

    override suspend fun getSimilarMovies(movieID: Int): Response<MoviesModel> {
        return apiInterface.getSimilarMovies(movieID)
    }

    override suspend fun getUpcomingMovies(): Response<MoviesModel> {
        return apiInterface.getUpcomingMovies()
    }

    override suspend fun getTvshows(): Response<TvShowModel> {
        return apiInterface.getPopularTvShows()
    }


}