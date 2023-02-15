package com.example.sendfund.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sendfund.R
import com.example.sendfund.databinding.FragmentSendFundBinding
import com.example.sendfund.viewmodel.SendFundViewModel

class SendFundFragment : Fragment() {

    companion object {
        fun newInstance() = SendFundFragment()
    }

    //    private lateinit var viewModel: SendFundViewModel
    private var _binding: FragmentSendFundBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

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

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(this).get(SendFundViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}