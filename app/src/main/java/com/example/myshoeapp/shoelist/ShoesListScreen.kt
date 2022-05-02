package com.example.myshoeapp.shoelist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.myshoeapp.R
import com.example.myshoeapp.databinding.FragmentShoesListScreenBinding

class ShoesListScreen : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding: FragmentShoesListScreenBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoes_list_screen, container, false)

        binding.fab.setOnClickListener {
            it.findNavController().navigate(ShoesListScreenDirections.actionShoesListScreenToShoeDetailScreen())
        }

        return binding.root
    }

}