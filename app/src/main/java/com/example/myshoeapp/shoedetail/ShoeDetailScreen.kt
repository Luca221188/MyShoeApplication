package com.example.myshoeapp.shoedetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.myshoeapp.R
import com.example.myshoeapp.databinding.FragmentShoeDetailScreenBinding
import com.example.myshoeapp.model.Shoe

//NOTE: I am not sure u really need ViewModel here...
class ShoeDetailScreen : Fragment() {
    private lateinit var binding: FragmentShoeDetailScreenBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_shoe_detail_screen, container, false)

        binding.cancelBtn.setOnClickListener {
            activity?.onBackPressed()
        }

        binding.saveBtn.setOnClickListener {
            val shoeToAdd: Shoe? = createNewShoe()
            if (shoeToAdd == null) {
                Toast.makeText(context, "Shoe is null", Toast.LENGTH_SHORT).show()
            }else {
                findNavController().navigate(ShoeDetailScreenDirections.actionShoeDetailScreenToShoesListScreen(shoeToAdd))
            }
        }

        return binding.root
    }

    private fun createNewShoe(): Shoe? {
        val name: EditText = binding.nameEdit
        val company: EditText = binding.companyEdit
        val size: EditText = binding.sizeEdit
        val description: EditText = binding.descriptionEdit

//        val nameString: String = name.text.toString()
//        val companyString: String = company.text.toString()
//        val sizeString: String = size.text.toString()
//        val descriptionString: String = description.text.toString()

        val nameString: String = "n"
        val companyString: String = "c"
        val sizeString: String = "1.4"
        val descriptionString: String = "d"

        return if (
            nameString.isEmpty() || nameString.isBlank() ||
            companyString.isEmpty() || companyString.isBlank() ||
            sizeString.isEmpty() || sizeString.isBlank() ||
            descriptionString.isEmpty() || descriptionString.isBlank()
        ) {
            null
        }else {
            Shoe(nameString, sizeString.toDouble(), companyString, descriptionString)
        }
    }
}