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
import com.lucassalbu.catalogodefilmessuperior.adapter.MovieAdapter
import com.lucassalbu.catalogodefilmessuperior.adapter.TvShowAdapter
import com.lucassalbu.catalogodefilmessuperior.databinding.FragmentHomeBinding
import com.lucassalbu.catalogodefilmessuperior.databinding.FragmentMoviesBinding
import com.lucassalbu.catalogodefilmessuperior.databinding.FragmentTvBinding
import com.lucassalbu.catalogodefilmessuperior.models.Movie
import com.lucassalbu.catalogodefilmessuperior.models.TvShow
import com.lucassalbu.catalogodefilmessuperior.ui.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TvFragment : Fragment() {

    lateinit var tvShowAdapter: TvShowAdapter

    private var _binding: FragmentTvBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTvBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
        getTvShow()
    }

    private fun initRecyclerView() {

        binding.rvTvShows.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        tvShowAdapter = TvShowAdapter()
        binding.rvTvShows.adapter = tvShowAdapter
    }

    private fun getTvShow() {

        viewModel.getTvShows()
        viewModel.tvShow.observe(viewLifecycleOwner) {
            tvShowAdapter.setTvShowList(it.tvShows as ArrayList<TvShow>)
            tvShowAdapter.notifyDataSetChanged()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}