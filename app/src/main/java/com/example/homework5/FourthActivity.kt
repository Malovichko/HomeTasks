package com.example.homework5

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class FourthActivity : AppCompatActivity() {

    private lateinit var curTimeView: TextView
    private lateinit var buttonGoToMe: Button
    val LOG_TAG = "myLogs"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fourth_activity)

        initViews()
        showCurTime()
        initListener()
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        showCurTime()
        Log.d(LOG_TAG, "onNewIintent")
    }

    private fun initViews() {
        curTimeView = findViewById(R.id.time_view)
        buttonGoToMe = findViewById(R.id.button_go_to_4_again)
    }

    companion object {
        const val TOTAL_COUNT = "total_count"
    }

    private fun showCurTime() {

        val curTime = intent.getStringExtra(TOTAL_COUNT)
//        val formatter = SimpleDateFormat("dd/MM/yyyy")
//        val dateString = formatter.format(curTime)
        curTimeView.text = curTime


//        curTimeView.text = Long.parse(curTime).toString()
    }

    private fun dataTransfer(){
        val intentFourthActivity = Intent(this, FourthActivity::class.java)
        val curTime = System.currentTimeMillis()
        intentFourthActivity.putExtra(TOTAL_COUNT, curTime.toString())
        startActivity(intentFourthActivity)
    }

    private fun initListener() {
        buttonGoToMe.setOnClickListener{
//            startActivity(Intent(this, FourthActivity::class.java))
            dataTransfer()
        }
    }

}