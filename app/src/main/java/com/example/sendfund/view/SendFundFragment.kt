package com.example.sendfund.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.navArgs
import com.example.sendfund.R
import com.example.sendfund.databinding.FragmentSendFundBinding
import com.example.sendfund.model.LoginResponseModel
import com.example.sendfund.viewmodel.SendFundViewModel
import java.lang.Double

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
        binding.tvName.text = userField.dataFromResponse?.userInfo?.UserName ?: ""
        binding.etBalance.setText("0")
        binding.tvbalanceBottom.text =
            "Balance" + " ${userField.dataFromResponse?.accountInfo?.currency}" + " ${userField.dataFromResponse?.accountInfo?.balance}"
        binding.etBalance.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                TODO("Not yet implemented")
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                var valueiInserted = p0.toString().toInt()
                var balance = userField.dataFromResponse?.accountInfo?.balance?.toInt() ?: 0
                if (valueiInserted > balance
                ) {
                    binding.rlError.visibility = View.GONE
                } else {
                    binding.rlError.visibility = View.VISIBLE
                }
            }

            override fun afterTextChanged(p0: Editable?) {
                TODO("Not yet implemented")
            }

        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
