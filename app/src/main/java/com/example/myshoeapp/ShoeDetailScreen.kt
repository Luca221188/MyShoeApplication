package com.example.myshoeapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.myshoeapp.databinding.FragmentShoeDetailScreenBinding

class ShoeDetailScreen : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding: FragmentShoeDetailScreenBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail_screen, container, false)

        return binding.root
    }
}