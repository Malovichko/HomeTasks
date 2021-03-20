package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.button.MaterialButton

class MainActivity2 : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var showButton: MaterialButton
    private lateinit var textView: TextView
    private var nameList = HashMap<Int, Student>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        initViews()
        initListener()
    }

    private fun initViews() {
        editText = findViewById(R.id.edit_text)
        showButton = findViewById(R.id.input)
        textView = findViewById(R.id.viewStudents)
    }

    private fun isDigit(str: String): Boolean {
        return str.all {
            it.isDigit()
        }
    }

    private fun isString(str: String): Boolean {
        return str.all {
            it.isLetter()
        }
    }

    private fun initListener() {
        showButton.setOnClickListener {
            var text = StringBuilder()
            for ((key, value) in nameList) {
                var data =
                    "ID = " + key.toString() + "\nName: " + value.firstName + "\nSurname : " + value.lastName + "\nGrade : " + value.grade + "\nBirthday year : " + value.birthdayYear + "\n\n"
                text.append(data)
            }
            textView.text = text
        }

        editText.setOnKeyListener { _, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                var names = ArrayList<String>()
                var inpStr = editText.text.toString().split(" ")
                var countWords = inpStr.count()
                println(countWords)
                if (countWords == 4 && inpStr[0].isNotEmpty() && inpStr[1].isNotEmpty() && inpStr[2].isNotEmpty() && inpStr[3].length == 4) {
                    names.addAll(inpStr)
                    if ((isString(names[0])) && (isString(names[1])) && (isDigit(names[3]))) {
                        if (names[3].toInt() in 1971..2019) {
                            var student = Student(names[0], names[1], names[2], names[3])
                            nameList.put(student.id, student)
                        }
                    } else {
                        Toast.makeText(
                            this@MainActivity2,
                            "Ошибка при вводе данных",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                } else {
                    Toast.makeText(
                        this@MainActivity2,
                        "Ошибка при вводе данных",
                        Toast.LENGTH_LONG
                    ).show()
                }
                editText.setText("")
                return@setOnKeyListener true
            }
            return@setOnKeyListener false
        }
    }
}