package com.example.androidhometasks.ht1.taskSequentialInput

class SequentialInputNumbersAndOperations {

    private var number1: Double = 0.0
    private var number2: Double = 0.0
    private var operation: String? = ""

    fun getIntAndOperation(): Double {
        var flag = true
        do {
            println("Введите первой число:")
            val stringNumber1 = readLine()?.toDoubleOrNull()
            if (stringNumber1 != null) {
                number1 = stringNumber1.toDouble()
                flag = false
            }
        } while (flag)

        do {
            println("Введите оператор (+,-,/,*):")
            flag = true
            val stringOperation = readLine()
            if (stringOperation != null
                && stringOperation.contains(Regex("[+-/*//]"))
                && stringOperation.count() < 2
            ) {
                operation = stringOperation
                flag = false
            }
        } while (flag)

        do {
            println("Введите второе число:")
            flag = true
            val stringNumber2 = readLine()?.toDoubleOrNull()
            if (stringNumber2 != null) {
                if (operation == "/" && stringNumber2 == 0.0) {
                    println("запрещено деление на 0")
                } else {
                    number2 = stringNumber2.toDouble()
                    flag = false
                }
            }
        } while (flag)

        println("$number1 $operation $number2 = $result")
        println("----------------------------------")
        return result
    }

    private val result: Double
        get() {
            return when (operation) {
                "+" -> number1 + number2
                "-" -> number1 - number2
                "*" -> number1 * number2
                "/" -> number1 / number2
                else -> 0.0
            }
        }

}