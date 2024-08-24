package com.example.kotlin_login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)
        //
        //XML elements
        val editTextUsername = findViewById<EditText>(R.id.EditText_name_input)
        val editTextEmail = findViewById<EditText>(R.id.EditText_email_input)
        val editTextPassword = findViewById<EditText>(R.id.EditText_password_input)
        val editTextPasswordConfirm = findViewById<EditText>(R.id.EditText_RepeatPassword_input)
        val registerButton = findViewById<Button>(R.id.login_button)

        //Register button listener
        registerButton.setOnClickListener{
            val username = usernameInput.text.toString().trim()
            val email = emailInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()
            val repeatPassword = repeatPasswordInput.text.toString().trim()

            //Validate username, email, password and repeat password
            if (username.isEmpty()) {
                usernameInput.error = "Please enter a valid username"
                usernameInput.requestFocus()
                return@setOnClickListener
            }

            if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                emailInput.error = "Please enter a valid email adress"
                emailInput.requestFocus()
                return@setOnClickListener
            }

            if (password.isEmpty() || password.length < 6) {
                passwordInput.error = "Password needs to have at least 6 characters"
                passwordInput.requestFocus()
                return@setOnClickListener
            }

            if (password != repeatPassword) {
                repeatPasswordInput.error = "Passwords don't match"
                repeatPasswordInput.requestFocus()
                return@setOnClickListener
            }

            //If all validations pass, navigate to WelcomeActivity
            val intent = Intent(this, WelcomeActivity::class.java)
            startActivity(intent)

            //Give feedback to user that registration was succesfull
            Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show()

        }

        //
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.register)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}