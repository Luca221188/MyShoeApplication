package com.example.myshoeapp.shoelist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.myshoeapp.R
import com.example.myshoeapp.databinding.FragmentShoesListScreenBinding
import com.example.myshoeapp.model.MyCustomView


class ShoesListScreen : Fragment() {
    private lateinit var shoeListViewModel: ShoeListViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding: FragmentShoesListScreenBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoes_list_screen, container, false)

        binding.fab.setOnClickListener {
            it.findNavController().navigate(ShoesListScreenDirections.actionShoesListScreenToShoeDetailScreen())
        }

        shoeListViewModel = ViewModelProvider(this).get(ShoeListViewModel::class.java)
        binding.shoeListViewModel = shoeListViewModel
        //binding.lifecycleOwner = viewLifecycleOwner

        val linearLayout = binding.shoeListLinearLayout

            shoeListViewModel.shoeList.value?.forEach {
                val myCustomView = MyCustomView(context)
                myCustomView.setDescription(it.description)
                myCustomView.setCompanyName(it.company)
                myCustomView.setShoeName(it.name)
                myCustomView.setShoeSize(it.size)

                linearLayout.addView(myCustomView)
            }

        return binding.root
    }

}