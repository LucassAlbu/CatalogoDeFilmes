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
import com.lucassalbu.catalogodefilmessuperior.models.TvShow
import com.lucassalbu.catalogodefilmessuperior.ui.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesFragment : Fragment() {

    lateinit var popularmovieAdapter: MovieAdapter
    lateinit var topRatedAdapter: MovieAdapter
    lateinit var upComingAdapter: MovieAdapter


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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
        getMovies()

    }

    private fun initRecyclerView() {
        binding.rvMovies.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        popularmovieAdapter = MovieAdapter()
        binding.rvMovies.adapter = popularmovieAdapter


        binding.rvTopMovies.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        topRatedAdapter = MovieAdapter()
        binding.rvTopMovies.adapter = topRatedAdapter

        binding.rvUpComingMovies.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        upComingAdapter = MovieAdapter()
        binding.rvUpComingMovies.adapter = upComingAdapter

    }


    private fun getMovies() {
        viewModel.getPopularMovie()
        viewModel.popularMovie.observe(viewLifecycleOwner) {
            popularmovieAdapter.setMovieList(it.movies as ArrayList<Movie>)
            popularmovieAdapter.notifyDataSetChanged()
        }
        viewModel.getTopMovie()
        viewModel.topMovie.observe(viewLifecycleOwner) {
            topRatedAdapter.setMovieList(it.movies as ArrayList<Movie>)
            topRatedAdapter.notifyDataSetChanged()
        }
        viewModel.getUpcomingMovies()
        viewModel.upcomingMovie.observe(viewLifecycleOwner) {
            upComingAdapter.setMovieList(it.movies as ArrayList<Movie>)
            upComingAdapter.notifyDataSetChanged()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}