package com.udacity.shoestore.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding
import com.udacity.shoestore.databinding.FragmentOnboardwelcomeBinding


class onboardwelcome : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentOnboardwelcomeBinding = FragmentOnboardwelcomeBinding.inflate(inflater,container,false)
        binding.btnnext.setOnClickListener{v->
            Navigation.findNavController(v).navigate(R.id.action_onboardwelcome_to_onboardinstructions)
        }

        return binding.root
    }

}