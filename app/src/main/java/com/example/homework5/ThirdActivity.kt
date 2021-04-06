package com.example.homework5

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar


class ThirdActivity : AppCompatActivity() {

    private lateinit var buttonGoTo1: Button
    private lateinit var buttonGoTo5: Button
    private lateinit var snackbar: Snackbar
    private lateinit var thView: View
    var FIFTH_ACTIVITY_REQUEST_CODE = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.third_activity)

        initViews()
        initListener()
    }

    private fun initViews() {
        thView = findViewById(R.id.thView)
        buttonGoTo1 = findViewById(R.id.button_go_to_1_on_3)
        buttonGoTo5 = findViewById(R.id.button_go_to_5)
    }

    private fun initListener() {
        buttonGoTo1.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        buttonGoTo5.setOnClickListener {
            startActivityForResult(
                Intent(this, FifthActivity::class.java),
                FIFTH_ACTIVITY_REQUEST_CODE
            )
        }
    }

    private fun showSnackBar(string: String) {
        snackbar =
            Snackbar.make(thView, string, Snackbar.LENGTH_LONG)
        snackbar.show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == FIFTH_ACTIVITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                val returnString = data?.getStringExtra("keyName")
                showSnackBar(returnString.toString())
            }
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)

    }


}