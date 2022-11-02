package com.lucassalbu.catalogodefilmessuperior.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lucassalbu.catalogodefilmessuperior.R
import com.lucassalbu.catalogodefilmessuperior.databinding.RvMoviesItemBinding
import com.lucassalbu.catalogodefilmessuperior.models.Movie
import com.lucassalbu.catalogodefilmessuperior.models.MoviesModel
import com.lucassalbu.catalogodefilmessuperior.ui.exhibition.MovieDetailFragment
import com.lucassalbu.catalogodefilmessuperior.ui.exhibition.MoviesFragment
import com.lucassalbu.catalogodefilmessuperior.utils.Constants.Companion.POSTER_BASE_URL
import dagger.hilt.android.AndroidEntryPoint


class MovieAdapter: RecyclerView.Adapter<MovieAdapter.MyViewHolder>() {

    var movieList = ArrayList<Movie>()

    @JvmName("setMovieList1")
    fun setMovieList(data: ArrayList<Movie>) {
        this.movieList = data
    }

    inner class MyViewHolder(val binding: RvMoviesItemBinding) :
        RecyclerView.ViewHolder(binding.root){

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            RvMoviesItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val movies = movieList[position]


        Glide.with(holder.binding.ivMoviePoster).load(POSTER_BASE_URL + movies.poster_path)
            .error(R.drawable.ic_logo).into(holder.binding.ivMoviePoster)

    }

    override fun getItemCount() = movieList.size



}