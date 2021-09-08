package com.example.loginscreennav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_sign_up_screen.*
import kotlinx.android.synthetic.main.fragment_sign_up_screen.view.*
import android.R.attr
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.JsonRequest
import com.android.volley.toolbox.StringRequest
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.HttpURLConnection
import java.net.URL
import android.R.attr.password
import androidx.navigation.Navigation

import com.android.volley.VolleyError
import org.json.JSONObject


class SignUpScreen : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view =inflater.inflate(R.layout.fragment_sign_up_screen, container, false)

        view.signUpButton.setOnClickListener() {
            listOf(nameBox.text.toString(), surnameBox.text.toString(), usernameBox.text.toString(),
                passwordBox.text.toString(), dateOfBirthBox.text.toString()).whenAllNotNull {




                val queue = Volley.newRequestQueue(context)


                var url = "http://192.168.1.87:6005/"
                val sl = "/"

                url = url + nameBox.text.toString() + sl + surnameBox.text.toString() + sl + usernameBox.text.toString() + sl + passwordBox.text.toString() + sl + dateOfBirthBox.text.toString()


                val jsonObjectRequest = JsonObjectRequest(
                    Request.Method.GET, url, null,
                    { response ->
                        Log.d("Response", "Response: %s".format(response.toString()))
                        Navigation.findNavController(view).navigate(R.id.action_signUpScreen_to_signUpSuccesfull)

                    },
                    { error ->
                        // TODO: Handle error
                        Log.d("Error", error.stackTraceToString())
                    }
                )


                queue.add(jsonObjectRequest)
            }
        }




        return view
    }


}




//this function is taken from https://stackoverflow.com/questions/35513636/multiple-variable-let-in-kotlin
fun <T: Any, R: Any> Collection<T?>.whenAllNotNull(block: (List<T>)->R) {
    if (this.all { it != null }) {
        block(this.filterNotNull()) // or do unsafe cast to non null collectino
    }
}