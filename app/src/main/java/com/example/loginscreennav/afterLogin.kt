package com.example.loginscreennav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_after_login.view.*


class afterLogin : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_after_login, container, false)

        view.button3.setOnClickListener() {
            Navigation.findNavController(view).navigate(R.id.action_afterLogin_to_login)
        }


        return view
    }


}