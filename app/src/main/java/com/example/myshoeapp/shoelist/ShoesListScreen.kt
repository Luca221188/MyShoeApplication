package com.example.myshoeapp.shoelist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.myshoeapp.R
import com.example.myshoeapp.databinding.FragmentShoesListScreenBinding
import com.example.myshoeapp.model.MyCustomView

/*
Note about ViewModel.
U can attach a ViewModel either to the Fragment itself or the Activity.
Considering the way u implemented the Navigation scheme, u should attach it to Activity.
The following is the Navigation Scheme:
        1                     2                                                     3
    ListScreen ------> ShoeDetailScreen ---(pop up to ListScreen inclusive)---> ListScreen
When u move from 2 to 3, u are going to create a new instance of ListScreen, while the previous one
on the back stack (1) is erased, along with 2.
- If u have assigned ViewModel to ListScreenFragment, by the time u reach 3 the old ListScreenFragment (1)
  is erased, along with all the data contained in the ViewModel connected to it. As a result, every
  time u create a new ListScreenFragment instance, a new ViewModel is instantiated. Your List will
  never be able to remember all the previously added Shoe objects
- If u have assigned ViewModel to Activity, your ViewModel is always kept, even when the ListScreenFragment
  instance is deleted. The only way for the app to destroy the ViewModel and the data linked to it is
  to destroy the Activity itself.
 */
class ShoesListScreen : Fragment() {
    private lateinit var shoeListViewModel: ShoeListViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding: FragmentShoesListScreenBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoes_list_screen, container, false)

        shoeListViewModel = ViewModelProvider(requireActivity()).get(ShoeListViewModel::class.java)
        binding.shoeListViewModel = shoeListViewModel
        //binding.lifecycleOwner = viewLifecycleOwner


        binding.fab.setOnClickListener {
            //set to true
            //problem is that u should give it to the Save Button in the next screen in order to make sense.
            //if u move to next screen activating the TRUE flag, and then u press Cancel Button and
            //come back here, the flag is still TRUE (should be FALSE)
            shoeListViewModel.onAddingShoeEventOpen()

            it.findNavController().navigate(ShoesListScreenDirections.actionShoesListScreenToShoeDetailScreen())
        }


        val linearLayout = binding.shoeListLinearLayout

        shoeListViewModel.shoeList.observe(viewLifecycleOwner) { list ->
            list.forEach {
                //Log.i("Into The List", "Creating the basic list..")
                //Toast.makeText(context, "Is filling the List a STATE?", Toast.LENGTH_SHORT).show()
                val myCustomView = MyCustomView(context)
                myCustomView.setDescription(it.description)
                myCustomView.setCompanyName(it.company)
                myCustomView.setShoeName(it.name)
                myCustomView.setShoeSize(it.size)

                linearLayout.addView(myCustomView)
            }
        }
        if (shoeListViewModel.addingNewShoeEvent.value == true) {
            val args = ShoesListScreenArgs.fromBundle(requireArguments())
            val newShoe = args.newShoe
            shoeListViewModel.setNewShoe(newShoe)

            //set to false
            shoeListViewModel.onAddingShoeEventCompleted()
        }


        return binding.root
    }
}