package com.example.hometask3

import android.os.Bundle
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CustomActivity: AppCompatActivity() {
    private lateinit var buttonExit: ImageView
    private lateinit var buttonEditToolbar: ImageView
    private lateinit var buttonEdit: FrameLayout
    private lateinit var buttonBack: ImageView
    private lateinit var textViewName: TextView
    private lateinit var textViewSurname: TextView
    private lateinit var textViewEmail: TextView
    private lateinit var textViewLogin: TextView
    private lateinit var textViewRegion: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.custom_activity)

        initViews()
        setTextInViews()
        initListener()
    }

    private fun initViews() {
        buttonExit = findViewById(R.id.custom_exit)
        buttonEditToolbar = findViewById(R.id.custom_edit)
        buttonEdit = findViewById(R.id.custom_canvas_edit)
        buttonBack = findViewById(R.id.custom_arrow_back)
        textViewName = findViewById(R.id.custom_data_name)
        textViewSurname = findViewById(R.id.custom_data_surname)
        textViewEmail = findViewById(R.id.custom_data_email)
        textViewLogin = findViewById(R.id.custom_data_login)
        textViewRegion = findViewById(R.id.custom_data_region)
    }

    private fun setTextInViews(){
        textViewName.setText(R.string.name)
        textViewSurname.setText(R.string.surname)
        textViewEmail.setText(R.string.email)
        textViewLogin.setText(R.string.login)
        textViewRegion.setText(R.string.region)
    }

    private fun initListener() {
        buttonExit.setOnClickListener {
            Toast.makeText(applicationContext, "Назад", Toast.LENGTH_SHORT).show()
        }
        buttonEditToolbar.setOnClickListener{
            Toast.makeText(applicationContext, "Редактировать", Toast.LENGTH_SHORT).show()
        }
        buttonEdit.setOnClickListener{
            Toast.makeText(applicationContext, "Редактировать", Toast.LENGTH_SHORT).show()
        }
        buttonBack.setOnClickListener{
            Toast.makeText(applicationContext, "Назад", Toast.LENGTH_SHORT).show()
        }
    }
}