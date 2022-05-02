package com.example.myshoeapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.myshoeapp.databinding.FragmentWelcomeScreenBinding

class WelcomeScreen : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentWelcomeScreenBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_welcome_screen, container, false)
        binding.welcomeBtn.setOnClickListener { it.findNavController().navigate(WelcomeScreenDirections.actionWelcomeScreenToInstructionsScreen()) }

        return binding.root
    }
}