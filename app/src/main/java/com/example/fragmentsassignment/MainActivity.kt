package com.example.fragmentsassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.fragmentsnotes.fragments.Fragment1
import com.example.fragmentsnotes.fragments.Fragment2

lateinit var fragButton1: Button
lateinit var fragButton2: Button
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragButton1 = findViewById(R.id.frag_button1)
        fragButton2 = findViewById(R.id.frag_button2)

        val frag1 = Fragment1()
        val frag2 = Fragment2()

        //User to load a fragment at any time into our fragment container
        supportFragmentManager.beginTransaction().apply{
            replace(R.id.fragment_container, frag1)
            commit()
        }

        fragButton1.setOnClickListener{
            supportFragmentManager.beginTransaction().apply{
                replace(R.id.fragment_container, frag1)
                addToBackStack(null)
                commit()
            }
        }

        fragButton2.setOnClickListener{
            val userInput = findViewById<EditText>(R.id.data_editText)
            frag2.arguments = passTheData(userInput.text.toString())
            supportFragmentManager.beginTransaction().apply{
                replace(R.id.fragment_container, frag2)
                addToBackStack(null)
                commit()
            }
        }

    }

    fun passTheData(passingText: String): Bundle {
        val bundle = Bundle()
        bundle.putString("userText",passingText)
        return bundle
    }
}