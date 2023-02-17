package com.example.sendfund.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.sendfund.R
import com.example.sendfund.databinding.FragmentSendFundBinding
import com.example.sendfund.model.LoginResponseModel
import com.example.sendfund.viewmodel.SendFundViewModel

class SendFundFragment : Fragment() {

    //    private lateinit var viewModel: SendFundViewModel
    private lateinit var userField: LoginResponseModel
    private var _binding: FragmentSendFundBinding? = null
    private val binding get() = _binding!!
    private val navigationArgs: SendFundFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSendFundBinding.inflate(
            inflater,
            container,
            false
        )
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userField = navigationArgs.user
        Log.d("TAG", "onViewCreated: $userField")
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
