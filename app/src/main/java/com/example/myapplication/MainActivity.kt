package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var addButton: MaterialButton
    private lateinit var showButton: MaterialButton
    private lateinit var textView: TextView
    private lateinit var secondWindow: MaterialButton

    //    private val  nameList = ArrayList<String>() //повторяющиеся имена
    private val sortedSet = TreeSet<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) //установка layout
        setSupportActionBar(findViewById(R.id.appBarlayout))

        initViews()
        initListeners()
    }

    private fun initViews() {
        editText = findViewById(R.id.edit_text) //R - класс с цифровымми идентификаторами
        addButton = findViewById(R.id.add)
        showButton = findViewById(R.id.show)
        textView = findViewById(R.id.textView)
        secondWindow = findViewById(R.id.second_window)

    }

    //выводить отсортированные строки в алфавитном порядке

    private fun initListeners() {
        addButton?.setOnClickListener {
            //Toast.makeText(this, "клик", Toast.LENGTH_LONG).show()
//            nameList.add(editText?.text.toString())
            sortedSet.add(editText?.text.toString())
            editText?.setText("")
            Toast.makeText(this, "Добавлено", Toast.LENGTH_LONG).show()


        }

        showButton?.setOnClickListener {
//            nameList.sort()
//            println(nameList)
            val text = sortedSet.joinToString(separator = "\n")
//            val text = nameList.joinToString(separator = "\n")
            textView.text = text

        }

        secondWindow?.setOnClickListener {
            startActivity(Intent(this, MainActivity2::class.java))
        }
    }

}

