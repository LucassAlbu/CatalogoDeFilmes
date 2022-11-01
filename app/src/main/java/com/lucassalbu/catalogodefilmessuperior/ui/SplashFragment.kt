package com.lucassalbu.catalogodefilmessuperior.ui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.lucassalbu.catalogodefilmessuperior.R
import com.lucassalbu.catalogodefilmessuperior.databinding.FragmentLoginBinding
import com.lucassalbu.catalogodefilmessuperior.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {

    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Handler(Looper.getMainLooper()).postDelayed(this::checkAuth, 3000)

    }

    private fun checkAuth() {
//        auth = Firebase.auth
//        if (auth.currentUser == null) {
           findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
//
//        } else {
//            findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
//        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

    }

}