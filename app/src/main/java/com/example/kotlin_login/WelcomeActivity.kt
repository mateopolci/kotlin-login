package com.example.kotlin_login

import android.os.Bundle
import android.widget.CheckBox
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.EditText

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val checkboxIOS = findViewById<CheckBox>(R.id.logo_ios)
        val checkboxAndroid = findViewById<CheckBox>(R.id.logo_android)
        val imageViewIOS = findViewById<ImageView>(R.id.imageview_ios)
        val imageViewAndroid = findViewById<ImageView>(R.id.imageview_android)

        // Listener para el CheckBox iOS
        checkboxIOS.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                checkboxAndroid.isChecked = false
                imageViewAndroid.visibility = View.GONE
                imageViewIOS.visibility = View.VISIBLE
            } else {
                imageViewIOS.visibility = View.GONE
            }
        }

        // Listener para el CheckBox Android
        checkboxAndroid.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                checkboxIOS.isChecked = false
                imageViewIOS.visibility = View.GONE
                imageViewAndroid.visibility = View.VISIBLE
            } else {
                imageViewAndroid.visibility = View.GONE
            }
        }

        val checkboxOtra = findViewById<CheckBox>(R.id.checkbox_otra)
        val edittextOther = findViewById<EditText>(R.id.edittext_other)

        checkboxOtra.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                edittextOther.visibility = View.VISIBLE
            } else {
                edittextOther.visibility = View.GONE
            }
        }
    }
}
