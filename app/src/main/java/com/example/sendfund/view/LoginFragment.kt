package com.example.sendfund.view

import android.os.Bundle
import android.text.InputFilter.LengthFilter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController

import androidx.navigation.fragment.findNavController
import com.example.sendfund.R
import com.example.sendfund.common.NetworkResult
import com.example.sendfund.databinding.FragmentLoginBinding
import com.example.sendfund.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    // TODO implement UI to call login method using this viewmodel
    private val loginViewModel: LoginViewModel by viewModels()


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

        binding.btnLogin.setOnClickListener {
            callLogin()
        }
    }

    private fun callLogin() {
        loginViewModel.loginResponse()
        loginViewModel.response.observe(viewLifecycleOwner) { response ->
            when (response) {
                is NetworkResult.Error -> {
                    Toast.makeText(requireActivity(), response.message, Toast.LENGTH_LONG).show()
                }
                is NetworkResult.Loading -> {

                }
                is NetworkResult.Success -> {
                    val action =
                        LoginFragmentDirections.actionLoginFragmentToSendFundFragment(user = response.data!!)
                    findNavController().navigate(action)

                }
            }

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}