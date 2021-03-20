package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var addButton: MaterialButton
    private lateinit var showButton: MaterialButton
    private lateinit var textView: TextView
    private lateinit var secondWindow: MaterialButton
    private val sortedSet = TreeSet<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.appBarlayout))

        initViews()
        initListeners()
    }

    private fun initViews() {
        editText = findViewById(R.id.edit_text)
        addButton = findViewById(R.id.add)
        showButton = findViewById(R.id.show)
        textView = findViewById(R.id.textView)
        secondWindow = findViewById(R.id.second_window)

    }


    private fun initListeners() {
        addButton.setOnClickListener {
            sortedSet.add(editText.text.toString())
            editText.setText("")
            Toast.makeText(this, "Добавлено", Toast.LENGTH_LONG).show()
        }

        showButton.setOnClickListener {
            val text = sortedSet.joinToString(separator = "\n")
            textView.text = text
        }

        secondWindow.setOnClickListener {
            startActivity(Intent(this, MainActivity2::class.java))
        }
    }

}

