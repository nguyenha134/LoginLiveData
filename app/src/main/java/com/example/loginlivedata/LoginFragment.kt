package com.example.loginlivedata

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.loginlivedata.databinding.FragmentLoginBinding

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
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        observeData()
    }

    private fun initView() {
        binding.btnLogin.setOnClickListener {
            viewModel.clickLogin(
                username1 = binding.edtName.text.toString(),
                password1 = binding.edtPassword.text.toString()
            )
        }
    }

    private fun observeData() {
        val successObserver: Observer<Boolean> = Observer { isSuccess ->
            if (isSuccess) {

            } else {
                Toast.makeText(
                    context,
                    "Username or Password is not empty",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

       viewModel.isSuccess.observe(viewLifecycleOwner, successObserver)
    }
}