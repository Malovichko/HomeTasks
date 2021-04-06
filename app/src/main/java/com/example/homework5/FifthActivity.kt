package com.example.homework5

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.homework5.data.Data

class FifthActivity constructor() : AppCompatActivity() {
    private lateinit var deliverResultButton: Button
    private lateinit var saveButton: Button
    private lateinit var editTextOn5: EditText
    private lateinit var editText: EditText
    private lateinit var textView: TextView
    val LOG_TAG = "myLogs"
    lateinit var str: Data

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fifth_activity)

        initViews()
        initListener()
        Log.d(LOG_TAG, "onCreate")
    }

    private fun initViews() {
        deliverResultButton = findViewById(R.id.deliver_result_button)
        saveButton = findViewById(R.id.button_save_result)
        editTextOn5 = findViewById(R.id.edit_text_on_fifth)
        editText = findViewById(R.id.edit_text)
        textView = findViewById(R.id.text_view_on_fifth)
    }

    private fun dataTransfer() {
        val stringToPassBack: String = editTextOn5.getText().toString()
        val intentFifthActivity = Intent(this, ThirdActivity::class.java)
        intentFifthActivity.putExtra("keyName", stringToPassBack)
        setResult(RESULT_OK, intentFifthActivity)
        finish()
    }

    private fun initListener() {
        deliverResultButton.setOnClickListener {
            dataTransfer()
        }
        saveButton.setOnClickListener {
            val text = collectUiData()
            textView.setText(text.value)

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LOG_TAG, "onDestroy")
    }

    override fun onPause() {
        super.onPause()
        Log.d(LOG_TAG, "onPause")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(LOG_TAG, "onRestart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(LOG_TAG, "onResume ")
    }

    override fun onStart() {
        super.onStart()
        Log.d(LOG_TAG, "onStart")
    }

    override fun onStop() {
        super.onStop()
        Log.d(LOG_TAG, "onStop")
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        Log.d(LOG_TAG, "onSaveInstanceState")
        outState.putParcelable("textView", collectUiData())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        str = savedInstanceState.getParcelable("textView")!!
        textView.setText(str.value.toString())
        Log.d(LOG_TAG, "onRestoreInstanceState")
    }

    private fun collectUiData() = Data(
        editText.text.toString()
    )


//    override fun onConfigurationChanged(newConfig: Configuration) {
//        super.onConfigurationChanged(newConfig)
//
//        // Checks the orientation of the screen
//        if (newConfig.orientation === Configuration.ORIENTATION_LANDSCAPE) {
//            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show()
////            openInfoData()
//            textView.setText(str.value.toString())
//        } else if (newConfig.orientation === Configuration.ORIENTATION_PORTRAIT) {
//            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show()
////            openInfoData()
//            textView.setText(str.value.toString())
//        }
//    }

    companion object {
        const val FIFTH_ACTIVITY_EXTRA = "FifthActivity.FIFTH_ACTIVITY_EXTRA"
        private const val DATA_REQUEST_CODE = 0
    }
}