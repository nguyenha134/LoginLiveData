package com.example.loginlivedata.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.loginlivedata.R
import com.example.loginlivedata.data.Constants
import com.example.loginlivedata.data.Constants.SHARED_PREFERENCE_NAME
import com.example.loginlivedata.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sharedPref = activity?.getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE) ?: return
        val name = sharedPref.getString(Constants.NAME, "")
        binding.btnBack.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_loginFragment2)
            Toast.makeText(context, name.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}