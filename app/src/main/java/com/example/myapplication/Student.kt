package com.example.myapplication

class Student(
    var firstName: String,
    var lastName: String,
    var grade: String,
    var birthdayYear: String
) {
    var id: Int = createID()
    private fun createID(): Int {
        return System.currentTimeMillis().toInt()
    }
}