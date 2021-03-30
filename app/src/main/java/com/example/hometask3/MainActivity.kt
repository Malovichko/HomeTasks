package com.example.hometask3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var constraintWindow: Button
    private lateinit var customWindow: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.intermediate_activity)

        initViews()
        initListener()
    }

    private fun initViews() {
        constraintWindow = findViewById(R.id.to_constraint_activity)
        customWindow = findViewById(R.id.to_custom_activity)

    }

    private fun initListener() {
        constraintWindow.setOnClickListener {
            startActivity(Intent(this, ConstraintActivity::class.java))
        }

        customWindow.setOnClickListener {
            startActivity(Intent(this, CustomActivity::class.java))
        }
    }
}