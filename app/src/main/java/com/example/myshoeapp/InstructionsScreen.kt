package com.example.myshoeapp

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.myshoeapp.databinding.FragmentInstructionsScreenBinding

class InstructionsScreen : Fragment() {
    private lateinit var binding: FragmentInstructionsScreenBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_instructions_screen, container, false)
        binding.instructionBtn.setOnClickListener { it.findNavController().navigate(InstructionsScreenDirections.actionInstructionsScreenToShoesListScreen()) }

        setHasOptionsMenu(true)

        return binding.root
    }
}