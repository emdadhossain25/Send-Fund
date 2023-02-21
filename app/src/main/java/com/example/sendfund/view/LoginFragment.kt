package com.example.sendfund.view

import `in`.aabhasjindal.otptextview.OTPListener
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels

import androidx.navigation.fragment.findNavController
import com.example.sendfund.common.NetworkResult
import com.example.sendfund.databinding.FragmentLoginBinding
import com.example.sendfund.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    // TODO implement UI to call login method using this viewmodel
    private val loginViewModel: LoginViewModel by viewModels()


    private var _binding: FragmentLoginBinding? = null
    private val binding
        get() = _binding!!

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


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var otp = binding.otpView.otp
        var userName =  binding.etUserName.text.toString()
        binding.otpView.otpListener = object : OTPListener {
            override fun onInteractionListener() {

            }

            override fun onOTPComplete(result: String?) {
                Log.d("onOTPComplete: ", otp?:"")
                otp = result
                userName = binding.etUserName.text.toString()
                binding.btnLogin.isEnabled =
                    loginViewModel.isPasswordLengthFour(otp) && loginViewModel.isUserNameNotEmpty(userName)

            }


        }



        binding.btnLogin.setOnClickListener {
            callLogin(userName, otp)
        }
    }

    private fun callLogin(username: String, password: String) {

        loginViewModel.loginResponse(username,password)
        loginViewModel.response.observe(viewLifecycleOwner) { response ->
            when (response) {
                is NetworkResult.Error -> {
                    Toast.makeText(requireActivity(), response.message, Toast.LENGTH_LONG).show()
                    loginViewModel.reinitializeData()
                    binding.indicator.visibility=View.GONE
                }
                is NetworkResult.Loading -> {
                    binding.indicator.visibility=View.VISIBLE
                }
                is NetworkResult.Success -> {
                    loginViewModel.reinitializeData()
                    val action =
                        LoginFragmentDirections.actionLoginFragmentToSendFundFragment(user = response.data!!)
                    findNavController().navigate(action)
                    binding.indicator.visibility=View.GONE

                }
            }

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}