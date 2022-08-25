package com.udacity.shoestore.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentAddshoeBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewmodels.GameViewModel


class Addshoe : Fragment() {
    private lateinit var viewModel:GameViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentAddshoeBinding = FragmentAddshoeBinding.inflate(inflater,container,false)
        viewModel = ViewModelProvider(requireActivity())[GameViewModel::class.java]


        binding.btnsave.setOnClickListener{
            val name=binding.txtname.text.toString()
            val company=binding.txtcompany.text.toString()
            val description=binding.txtcompany.text.toString()
            val size=binding.txtnum.text.toString()

            val s=Shoe(name = name, size = size, company = company,description=description)
            viewModel.additem(s)
            Navigation.findNavController(it).navigate(R.id.action_addshoe_to_home2)
        }
        binding.btncancel.setOnClickListener{
            Navigation.findNavController(it).popBackStack()
        }
        return binding.root
    }
}