package com.example.myshoeapp

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.myshoeapp.databinding.FragmentLoginScreenBinding

class LoginScreen : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding: FragmentLoginScreenBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_login_screen, container, false)

        binding.apply {
            signInBtn.setOnClickListener { navigateToWelcomeScreen(it) }
            signUpBtn.setOnClickListener { navigateToWelcomeScreen(it) }
        }

        setHasOptionsMenu(true)

        return binding.root
    }

    private fun navigateToWelcomeScreen(view: View) {
        view.findNavController().navigate(LoginScreenDirections.actionLoginScreenToWelcomeScreen())
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        //clear the menu for this Fragment
        menu.clear()
    }
}