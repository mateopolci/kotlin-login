package com.example.kotlin_login

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

//Custom imports
import android.content.Intent
import android.widget.Toast

//XML elements import
import android.widget.Button
import android.widget.EditText


//Hardcoded login credentials
const val user = "Juan Torres"
const val pass = "1234utn"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        //
        //XML elements
        val editTextUsername = findViewById<EditText>(R.id.username_input)
        val editTextPassword = findViewById<EditText>(R.id.password_input)
        val loginButton = findViewById<Button>(R.id.login_button)

        //Login button listener
        loginButton.setOnClickListener {

            //Store username and password
            val username = editTextUsername.text.toString()
            val password = editTextPassword.text.toString()

            //Check if username and password are correct
            if (username == user && password == pass){
                //If correct, go to welcome activity
                val intent = Intent(this, WelcomeActivity::class.java)
                startActivity(intent)
            }else{
                //If incorrect, show error message
                Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
            }
        }
        //


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}