package com.lucassalbu.catalogodefilmessuperior.ui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.lucassalbu.catalogodefilmessuperior.R
import com.lucassalbu.catalogodefilmessuperior.databinding.FragmentLoginBinding
import com.lucassalbu.catalogodefilmessuperior.databinding.FragmentSplashBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : Fragment() {

    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!

    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = Firebase.auth
        Handler(Looper.getMainLooper()).postDelayed(this::checkAuth, 3000)

    }
//checando se o usuario está logado
    //TODO Implementar o botão Swith para usuario marcar se quer se manter logado ou não
    //ideia: nesse chek colocar um novo if else, segindo os estados do botão, e se estiver marcado só seguir para outra pag
    //igual cod abaixo
    //se não estiver marcado, forçar função do botão logout
    private fun checkAuth() {
        auth = Firebase.auth
        if (auth.currentUser == null) {
            findNavController().navigate(R.id.action_splashFragment_to_loginFragment)

        } else {
            findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

    }

}