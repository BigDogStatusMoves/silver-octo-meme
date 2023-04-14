package com.example.fragmentsnotes.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.fragmentsassignment.R

class Fragment2 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_2, container, false)
        val displayMessage = arguments?.getString("userText")
        val txtReceived = view.findViewById<TextView>(R.id.dataPassed_text)
        txtReceived.setText(displayMessage)
        return view
    }



}