package com.lucassalbu.catalogodefilmessuperior.ui.exhibition

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.lucassalbu.catalogodefilmessuperior.R
import com.lucassalbu.catalogodefilmessuperior.databinding.FragmentHomeBinding
import com.lucassalbu.catalogodefilmessuperior.databinding.FragmentMoviesBinding
import com.lucassalbu.catalogodefilmessuperior.databinding.FragmentTvBinding
import com.lucassalbu.catalogodefilmessuperior.ui.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TvFragment : Fragment() {

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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}