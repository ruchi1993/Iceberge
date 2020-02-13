package com.hsbc.kinetic.login_ui

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RelativeLayout
import android.widget.Toast
import com.hsbc.kinetic.login.dbb.SharedPref


class LoginFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView: View = inflater.inflate(R.layout.fragment_login, container, false)
        val usrName = rootView.findViewById<EditText>(R.id.username)
        val usrPass = rootView.findViewById<EditText>(R.id.userpass)
        val usrNameLoginBtn = rootView.findViewById<Button>(R.id.continueUserBtn)
        val passLoginBtn = rootView.findViewById<Button>(R.id.continuePasswordBtn)
        val userView = rootView.findViewById<RelativeLayout>(R.id.rlUserView)
        val passwordView = rootView.findViewById<RelativeLayout>(R.id.rlPasswordView)


        usrNameLoginBtn.setOnClickListener(View.OnClickListener {
            if (!usrName.text.isEmpty()) {
                val shared = SharedPref()
                shared.saveUserName(view?.context, usrName.text.toString())
                userView.visibility = View.GONE
                passwordView.visibility = View.VISIBLE
            } else {
                Toast.makeText(rootView.context, "Please enter user name", Toast.LENGTH_SHORT)
                    .show()
            }
        })

        passLoginBtn.setOnClickListener(View.OnClickListener {
            if (!usrPass.text.isEmpty()) {
                val shared = SharedPref()
                shared.saveUserPassword(view?.context, usrPass.text.toString())
                val intent = Intent(view?.context, HomeActivity::class.java)
                startActivity(intent)
            }
        })

        return rootView
    }

}
