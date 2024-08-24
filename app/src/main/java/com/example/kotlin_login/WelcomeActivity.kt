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

        checkboxIOS.setOnCheckedChangeListener { _, isChecked ->
            imageViewIOS.visibility = if (isChecked) ImageView.VISIBLE else ImageView.GONE
        }

        checkboxAndroid.setOnCheckedChangeListener { _, isChecked ->
            imageViewAndroid.visibility = if (isChecked) ImageView.VISIBLE else ImageView.GONE
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