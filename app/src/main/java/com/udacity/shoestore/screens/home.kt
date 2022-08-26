package com.udacity.shoestore.screens

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentHomeBinding
import com.udacity.shoestore.viewmodels.GameViewModel
import timber.log.Timber


class home : Fragment() ,MenuProvider{
    private lateinit var viewModel: GameViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding:FragmentHomeBinding=FragmentHomeBinding.inflate(inflater,container,false)
        viewModel = ViewModelProvider(requireActivity())[GameViewModel::class.java]
        val myLayout: LinearLayout = binding.layout


        viewModel.shoes.observe(viewLifecycleOwner) {
            Timber.d("in my ")
            it.forEach { i ->
                val txt = TextView(context)
                txt.layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                txt.text = "name: ${i.name}\n company: ${i.company}\n size: ${i.size}\n description: ${i.description} \n \n"
                myLayout.addView(txt)
            }
        }


        binding.floatingActionButton.setOnClickListener{v->
            Navigation.findNavController(v).navigate(R.id.action_home2_to_addshoe)}


        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.RESUMED)


        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.menu, menu)
        super.onCreateOptionsMenu(menu,menuInflater)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id==R.id.logout){
            logout()
        }
       return super.onOptionsItemSelected(item)
    }
    fun logout() {
        val sharedPreference = requireContext().getSharedPreferences("Data", Context.MODE_PRIVATE)
        var editor = sharedPreference.edit()
        editor.clear()
        editor.commit()
        val navHostFragment =
            (activity as FragmentActivity).supportFragmentManager.findFragmentById(R.id.frag_host) as NavHostFragment
        val navController = navHostFragment.navController
        navController.navigate(R.id.action_home2_to_login)
    }

}

