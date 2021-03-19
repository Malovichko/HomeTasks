package com.example.myapplication

//public abstract class Student{
//    public abstract var id : Int
//    public var name: String = ""
//    public lateinit var surname : String
//    public lateinit var grade : String
//    public  var birthdayYear: Int = 0
//}

class Student(
    var firstName: String,
    var lastName: String,
    var grade: String,
    var birthdayYear: String
)
{
    var id: Int = createID()
    private fun createID(): Int {
        return System.currentTimeMillis().toInt()
    }
}