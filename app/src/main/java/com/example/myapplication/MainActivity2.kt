package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.EditText
import android.widget.TextView
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

    private fun initListener() {
        showButton?.setOnClickListener {
            var text = StringBuilder()
            for ((key, value) in nameList) {
                var data =
                    "ID = " + key.toString() + "\nName: " + value.firstName + "\nSurname : " + value.lastName + "\ngrade : " + value.grade + "\nbirthday year : " + value.birthdayYear + "\n\n"
                text.append(data)
            }
            textView.text = text
        }

        editText.setOnKeyListener(object : View.OnKeyListener {
            override fun onKey(v: View?, keyCode: Int, event: KeyEvent): Boolean {
                if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                    var names = ArrayList<String>()
                    names.addAll(editText?.text.toString().split(" "))
                    var student = Student(names[0], names[1], names[2], names[3])
                    nameList.put(student.id, student)
//                    if (editText.length() > 0) {
//                        TextKeyListener.clear(editText.getText());
//                    }
                    editText?.setText("")
                    return true
                }
                return false
            }
        })
    }
}