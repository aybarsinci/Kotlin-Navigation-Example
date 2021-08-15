package com.example.loginscreennav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_login.view.*


class login : Fragment() {

    val map: HashMap<String, String> = hashMapOf("aybars6" to "kck12", "kobo" to "mamamia", "talo" to "darthrevan")



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_login, container, false)


        view.button.setOnClickListener() {
            var name = editTextTextPassword.text.toString()

            if(map.containsKey(name)) {
                if(editTextTextPassword2.text.toString().equals(map.get(name))) {
                    Navigation.findNavController(view).navigate(R.id.action_login_to_afterLogin)
                } else {
                    textView.text = "Incorrect ID and password"
                }
            } else {
                textView.text = "Incorrect ID and password"
            }
        }




        return view
    }

}