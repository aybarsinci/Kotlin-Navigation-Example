package com.example.loginscreennav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_sign_up_succesfull.*
import kotlinx.android.synthetic.main.fragment_sign_up_succesfull.view.*

class signUpSuccesfull : Fragment() {




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_sign_up_succesfull, container, false)


        view.go_back_to_login_screen.setOnClickListener() {
            Navigation.findNavController(view).navigate(R.id.action_signUpSuccesfull_to_login)
        }


        return view




    }


}