package com.example.androidhometasks.ht1

import com.example.androidhometasks.ht1.menu.Menu


fun main(){


val menu = Menu().printMenu()


//val sad = readLine()?.let { print("=") } ?: println("Not")

    /*if (checkInput(strong)) {
        println("God")
        println(resultSum(strong))
    }
    else{
        println("Not")
    }*/


    val string = "22+25/5*(12312+3)".replace(" ","")

   val sad =  formattingInputString(string)

//resultSum(sad)
}


private fun formattingInputString(value: String): List<String> {
    val string = mutableListOf<String>()
    var tempString = ""
    val arrayOperations = charArrayOf('+', '-', '*', '/', '(', ')')
    value.forEach {
        if (it in '0'..'9')
            tempString += it
        if (it in arrayOperations) {
            if (tempString != "") {
                string.add(tempString)
            }
            string.add(it.toString())
            tempString = ""
        }
    }
    return string
}


fun checkInput(input : String) : Boolean {
    val integetChars = '0'..'9'
    val operationsChars = charArrayOf('-', '+', '/', '*', '(', ')')
    return input.all { it in integetChars && input.count() > 1 && it in operationsChars }
}

fun resultSum(value:List<String>):Int{

    return 0
}