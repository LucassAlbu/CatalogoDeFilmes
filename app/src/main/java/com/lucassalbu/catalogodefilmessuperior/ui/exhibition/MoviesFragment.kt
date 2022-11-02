package com.lucassalbu.catalogodefilmessuperior.ui.exhibition

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lucassalbu.catalogodefilmessuperior.R
import com.lucassalbu.catalogodefilmessuperior.databinding.FragmentMoviesBinding
import com.lucassalbu.catalogodefilmessuperior.adapter.MovieAdapter
import com.lucassalbu.catalogodefilmessuperior.databinding.FragmentHomeBinding
import com.lucassalbu.catalogodefilmessuperior.models.Movie
import com.lucassalbu.catalogodefilmessuperior.ui.MainViewModel


class MoviesFragment : Fragment() {

    lateinit var popularmovieAdapter: MovieAdapter
    lateinit var topRatedAdapter: MovieAdapter

    private val viewModel: MainViewModel by viewModels()

    private var _binding: FragmentMoviesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMoviesBinding.inflate(inflater, container, false)
        return binding.root
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        initRecyclerView()
//        getMovies()
//
//    }

//    private fun initRecyclerView() {
//        binding.rvMovies.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL,false)
//        popularmovieAdapter = MovieAdapter(this)
//        binding.rvMovies.adapter = popularmovieAdapter
//
////        binding.rvTopMovies.layoutManager = LinearLayoutManager( this, RecyclerView.HORIZONTAL,false)
////        topRatedAdapter = MovieAdapter(this)
////        binding.rvTopMovies.adapter = topRatedAdapter
//    }
//
//    private fun getMovies() {
//        viewModel.getPopularMovie()
//        viewModel.popularMovie.observe(viewLifecycleOwner) {
//            popularmovieAdapter.setMovieList(it.movies as ArrayList<Movie>)
//            popularmovieAdapter.notifyDataSetChanged()
//        }
////        viewModel.getTopMovie()
////        viewModel.topMovie.observe(this){
////            topRatedAdapter.setMovieList(it.movies as ArrayList<Movie>)
////            topRatedAdapter.notifyDataSetChanged()
////}
////        }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}