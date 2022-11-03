package com.lucassalbu.catalogodefilmessuperior.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lucassalbu.catalogodefilmessuperior.models.MovieDetailModel
import com.lucassalbu.catalogodefilmessuperior.models.MoviesModel
import com.lucassalbu.catalogodefilmessuperior.models.TvShow
import com.lucassalbu.catalogodefilmessuperior.models.TvShowModel
import com.lucassalbu.catalogodefilmessuperior.repositories.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private var _popularMovie = MutableLiveData<MoviesModel>()
    val popularMovie: LiveData<MoviesModel> = _popularMovie

    private var _movieDetailModel = MutableLiveData<MovieDetailModel>()
    val movieDetailModel: LiveData<MovieDetailModel> = _movieDetailModel

    private var _topMovie = MutableLiveData<MoviesModel>()
    val topMovie: LiveData<MoviesModel> = _topMovie

    private var _similarMovie = MutableLiveData<MoviesModel>()
    val similarMovie: LiveData<MoviesModel> = _similarMovie

    private var _UpcomingMovie =  MutableLiveData<MoviesModel>()
    val upcomingMovie: LiveData<MoviesModel> = _UpcomingMovie

    private var _tvShows = MutableLiveData<TvShowModel>()
    val tvShow : LiveData<TvShowModel> = _tvShows

    fun getPopularMovie() {
        viewModelScope.launch {
            val response = repository.getPopularMovie()
            _popularMovie.postValue(response.body())
        }
    }
    fun getMovieDetail(movieID: Int){
        viewModelScope.launch {
            val response = repository.getMovieDetail(movieID)
            _movieDetailModel.postValue(response.body())
        }
    }

    fun getTopMovie(){
        viewModelScope.launch {
            val response = repository.getTopRated()
            _topMovie.postValue(response.body())

        }
    }

    fun getSimilarMovies(movieID: Int){
        viewModelScope.launch {
            val response = repository.getSimilarMovies(movieID)
            _similarMovie.postValue(response.body())
        }
    }
    fun getUpcomingMovies(){
        viewModelScope.launch {
            val response = repository.getUpcomingMovies()
            _UpcomingMovie.postValue(response.body())
        }
    }
    fun getTvShows(){
        viewModelScope.launch{
            val response = repository.getTvshows()
            _tvShows.postValue(response.body())
        }
    }

}