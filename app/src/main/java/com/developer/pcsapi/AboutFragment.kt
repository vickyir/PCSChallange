package com.developer.pcsapi

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.developer.pcsapi.LoginActivity.Companion.sessionManager

class AboutFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_about, container, false)

        val btnLogout = view.findViewById<Button>(R.id.buttonLogout)

        btnLogout.setOnClickListener {
            sessionManager.clearSession()

            val moveIntent = Intent(activity, LoginActivity::class.java)
            startActivity(moveIntent)
            activity?.finish()
        }

        return view
    }


}