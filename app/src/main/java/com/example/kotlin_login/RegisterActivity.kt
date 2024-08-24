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

        // XML elements
        val editTextUsername = findViewById<EditText>(R.id.EditText_name_input)
        val editTextEmail = findViewById<EditText>(R.id.EditText_email_input)
        val editTextPassword = findViewById<EditText>(R.id.EditText_password_input)
        val editTextPasswordConfirm = findViewById<EditText>(R.id.EditText_RepeatPassword_input)
        val registerButton = findViewById<Button>(R.id.login_button)

        registerButton.setOnClickListener {
            val username = editTextUsername.text.toString().trim()
            val email = editTextEmail.text.toString().trim()
            val password = editTextPassword.text.toString().trim()
            val repeatPassword = editTextPasswordConfirm.text.toString().trim()

            // Validate username, email, password and repeat password
            if (username.isEmpty()) {
                editTextUsername.error = "Please enter a valid username"
                editTextUsername.requestFocus()
                return@setOnClickListener
            }

            if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                editTextEmail.error = "Please enter a valid email address"
                editTextEmail.requestFocus()
                return@setOnClickListener
            }

            if (password.isEmpty() || password.length < 6) {
                editTextPassword.error = "Password needs to have at least 6 characters"
                editTextPassword.requestFocus()
                return@setOnClickListener
            }

            if (password != repeatPassword) {
                editTextPasswordConfirm.error = "Passwords don't match"
                editTextPasswordConfirm.requestFocus()
                return@setOnClickListener
            }

            // If all validations pass, navigate to WelcomeActivity
            val intent = Intent(this, WelcomeActivity::class.java)
            startActivity(intent)

            // Give feedback to user that registration was successful
            Toast.makeText(this, "Succesfull register", Toast.LENGTH_SHORT).show()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.register)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
