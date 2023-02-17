package com.example.sendfund.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.sendfund.databinding.FragmentLoginBinding
import com.example.sendfund.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint


class LoginFragment : Fragment() {

    // TODO implement UI to call login method using this viewmodel
    private val viewModel by viewModels<LoginViewModel>()


    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(
            inflater,
            container,
            false
        )
        val view = binding.root
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        val action =
            LoginFragmentDirections.actionLoginFragmentToSendFundFragment(username = "nadimh")
        binding.btnLogin.setOnClickListener {
            findNavController().navigate(action)
        }
        // TODO: Use the ViewModel
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}