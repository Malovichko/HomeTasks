package com.example.homework5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var buttonGoTo4: Button
    private lateinit var buttonGoTo2: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        initListener()
    }

    private fun initViews() {
        buttonGoTo2 = findViewById(R.id.button_go_to_2)
        buttonGoTo4 = findViewById(R.id.button_go_to_4)
    }

    private fun dataTransfer(){
        val intentFourthActivity = Intent(this, FourthActivity::class.java)
        val curTime = System.currentTimeMillis()
        intentFourthActivity.putExtra(FourthActivity.TOTAL_COUNT, curTime.toString())
        startActivity(intentFourthActivity)
    }

    private fun initListener() {
        buttonGoTo2.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
        buttonGoTo4.setOnClickListener{
            dataTransfer()
        }
    }

}