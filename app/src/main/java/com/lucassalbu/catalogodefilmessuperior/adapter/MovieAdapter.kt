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
import com.lucassalbu.catalogodefilmessuperior.ui.exhibition.MovieDetailFragment
import com.lucassalbu.catalogodefilmessuperior.utils.Constants.Companion.POSTER_BASE_URL

class MovieAdapter(
    private val context: Context
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    var movieList = ArrayList<Movie>()

    @JvmName("setMovieList1")
    fun setMovieList(data: ArrayList<Movie>) {
        this.movieList = data
    }


    class MovieViewHolder(
        private val binding: RvMoviesItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bindingMovieList(movie: Movie, context: Context) {
//            binding.tvTitle.text = movie.title.toString().trim()
//            binding.tvReleaseYear.text = movie.release_date.toString().format()
//            binding.tvGenre.text = movie.genre_ids[0].toString().trim()

            Glide.with(binding.ivMoviePoster).load(POSTER_BASE_URL + movie.poster_path)
                .error(R.drawable.ic_logo).into(binding.ivMoviePoster)

            binding.cdPrincipal.setOnClickListener {
                val intent = Intent(context, MovieDetailFragment::class.java)
                intent.putExtra("movieID", movie.id)
                context.startActivity(intent)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = RvMoviesItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {

        holder.bindingMovieList(movieList[position], context)

    }

    override fun getItemCount() = movieList.size


}