package com.example.secondhomework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    private lateinit var secondWindow: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        initListener()
    }

    private fun initViews() {
        secondWindow = findViewById(R.id.button)

    }

    private  fun initListener(){
        secondWindow?.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
    }

}