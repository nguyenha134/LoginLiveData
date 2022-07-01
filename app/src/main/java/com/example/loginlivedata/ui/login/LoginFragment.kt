package com.example.loginlivedata.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.loginlivedata.R
import com.example.loginlivedata.data.User
import com.example.loginlivedata.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null

    private val binding
        get() = _binding!!
    lateinit var viewModel: LoginViewModel
    //?: optional

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        observeData()
        binding.edtName.setText(viewModel.getUser().name)
        binding.edtPassword.setText(viewModel.getUser().password)
        binding.cbSaveSession.isChecked = viewModel.isSessionSaved()
    }

    private fun initView() {
        binding.btnLogin.setOnClickListener {
            saveData()
            viewModel.clickLogin(
                username1 = binding.edtName.text.toString(),
                password1 = binding.edtPassword.text.toString()
            )
        }
    }

    private fun observeData() {
        val successObserver: Observer<Boolean> = Observer { isSuccess ->
            if (isSuccess) {
                findNavController().navigate(R.id.action_loginFragment2_to_homeFragment)
            } else {
                Toast.makeText(
                    context,
                    "Login Fail",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        viewModel.isSuccess.observe(viewLifecycleOwner, successObserver)
    }

    private fun saveData() {
        viewModel.saveSession(checked = binding.cbSaveSession.isChecked)
        if (binding.cbSaveSession.isChecked) {
//            viewModel.saveUsername(username = binding.edtName.text.toString())
//            viewModel.savePassword(password = binding.edtPassword.text.toString())
            viewModel.saveUser(user = User(binding.edtName.text.toString(), binding.edtPassword.text.toString()))
        } else {
//            viewModel.saveUsername(username = "")
//            viewModel.savePassword(password = "")
            viewModel.saveUser(user = User("", ""))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}