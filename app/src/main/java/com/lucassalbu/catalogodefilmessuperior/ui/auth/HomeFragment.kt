package com.lucassalbu.catalogodefilmessuperior.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.lucassalbu.catalogodefilmessuperior.R
import com.lucassalbu.catalogodefilmessuperior.databinding.FragmentHomeBinding
import com.lucassalbu.catalogodefilmessuperior.ui.exhibition.MoviesFragment
import com.lucassalbu.catalogodefilmessuperior.ui.exhibition.TrendingFragment
import com.lucassalbu.catalogodefilmessuperior.ui.exhibition.TvFragment
import com.lucassalbu.catalogodefilmessuperior.adapter.ViewPagerAdapter


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var auth: FirebaseAuth


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = Firebase.auth

        configTablayout()
        initClicks()

    }

    private fun initClicks() {
        binding.ibLogout.setOnClickListener { loggoutApp() }
    }

    private fun loggoutApp() {
        auth.signOut()
        findNavController().navigate(R.id.action_homeFragment_to_loginFragment)
    }

    private fun configTablayout() {
        val adapter = ViewPagerAdapter(requireActivity())
        binding.viewPager.adapter = adapter

        adapter.addFragment(MoviesFragment(), "Filmes")
        adapter.addFragment(TvFragment(), "Programas de TV")
        adapter.addFragment(TrendingFragment(), "Trendings da semana")

        binding.viewPager.offscreenPageLimit = adapter.itemCount

        TabLayoutMediator(
            binding.tabs, binding.viewPager
        ) { tab, position ->
            tab.text = adapter.getTitle(
                position
            )
        }.attach()

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}