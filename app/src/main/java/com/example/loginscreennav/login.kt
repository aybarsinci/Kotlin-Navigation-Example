package com.example.loginscreennav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_login.view.*

import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.JsonRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.HttpURLConnection
import java.net.URL
import android.R.attr.password

import com.android.volley.VolleyError
import kotlinx.android.synthetic.main.fragment_sign_up_screen.view.*
import org.json.JSONObject

class login : Fragment() {

    val map: HashMap<String, String> = hashMapOf("aybars6" to "kck12", "kobo" to "mamamia", "talo" to "darthrevan")



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_login, container, false)


        view.button.setOnClickListener() {


            val queue = Volley.newRequestQueue(context)


            var url = "http://192.168.1.87:6005/"

            url += editTextTextPassword.text.toString()

            var passwordCame : String



            val jsonObjectRequest = JsonObjectRequest(
                Request.Method.GET, url, null,
                { response ->
                    Log.d("Response", "Response: %s".format(response.get(editTextTextPassword.text.toString())))
                    Log.d("response", response.toString())
                    passwordCame = response.get(editTextTextPassword.text.toString()).toString()
                    Log.d("tag", passwordCame)
                    passwordCame = passwordCame.drop(2)
                    passwordCame = passwordCame.dropLast(2)
                    Log.d("tag", passwordCame)


                    if(passwordCame.equals(editTextTextPassword2.text.toString())) {
                            Navigation.findNavController(view).navigate(R.id.action_login_to_afterLogin)
                        } else {
                        textView.text = "Incorrect ID and password"
                    }



                },
                { error ->
                    // TODO: Handle error
                    Log.d("Error", error.stackTraceToString())
                    textView.text = "Incorrect ID and password"
                }
            )
            queue.add(jsonObjectRequest)










            /*var name = editTextTextPassword.text.toString()

            if(map.containsKey(name)) {
                if(editTextTextPassword2.text.toString().equals(map.get(name))) {
                    Navigation.findNavController(view).navigate(R.id.action_login_to_afterLogin)
                } else {
                    textView.text = "Incorrect ID and password"
                }
            } else {
                textView.text = "Incorrect ID and password"
            }*/
        }

        view.Sign_up_button.setOnClickListener() {
            Navigation.findNavController(view).navigate(R.id.action_login_to_signUpScreen)
        }




        return view
    }

}