package com.udacity.shoestore

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.udacity.shoestore.databinding.FragmentSplashBinding
import timber.log.Timber


class splash : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val sharedPreference = requireContext().getSharedPreferences("Data", Context.MODE_PRIVATE)
        var editor = sharedPreference.edit()
        val binding: FragmentSplashBinding = FragmentSplashBinding.inflate(inflater,container,false)
        val islogin=sharedPreference.getBoolean("islogin",false)
        val navHostFragment = (activity as FragmentActivity).supportFragmentManager.findFragmentById(R.id.frag_host) as NavHostFragment
        val navController = navHostFragment.navController
        if (islogin){
            navController.navigate(R.id.action_splash_to_home2)
        }else{
            navController.navigate(R.id.action_splash_to_login)
        }
        return binding.root
    }

}