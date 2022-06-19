package com.example.loginlivedata

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.loginlivedata.databinding.FragmentLoginBinding
import kotlinx.android.synthetic.main.fragment_login.*
import java.util.*


class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        initView()
        return binding.root
    }

    fun initView() {
        binding.btnLogin.setOnClickListener {
            viewModel.clickLogin(username1 = binding.edtName.text.toString(), password1 = binding.edtPassword.text.toString())
        }
    }


}