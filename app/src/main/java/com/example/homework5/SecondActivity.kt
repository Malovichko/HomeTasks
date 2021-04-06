package com.example.homework5

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SecondActivity :AppCompatActivity(){

    private lateinit var buttonGoTo3: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)

        initViews()
        initListener()

    }

    private fun initViews(){
        buttonGoTo3 = findViewById(R.id.button_go_to_3)
    }

    private fun initListener(){
        buttonGoTo3.setOnClickListener{
            startActivity(Intent(this, ThirdActivity::class.java))
        }
    }
}