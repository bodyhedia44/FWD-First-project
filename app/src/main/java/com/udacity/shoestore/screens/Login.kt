package com.udacity.shoestore.screens

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentHomeBinding
import com.udacity.shoestore.databinding.FragmentLoginBinding
import timber.log.Timber


class Login : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val sharedPreference = requireContext().getSharedPreferences("Data",Context.MODE_PRIVATE)
        var editor = sharedPreference.edit()
        val binding: FragmentLoginBinding = FragmentLoginBinding.inflate(inflater,container,false)
        binding.Login.setOnClickListener{v->
            editor.putBoolean("islogin",true)
            editor.commit()
            Navigation.findNavController(v).navigate(R.id.action_login_to_onboardwelcome3)

        }
        binding.Cre.setOnClickListener{v->
            editor.putBoolean("islogin",true)
            editor.commit()
            Navigation.findNavController(v).navigate(R.id.action_login_to_onboardwelcome3)
        }


        return binding.root
    }

}