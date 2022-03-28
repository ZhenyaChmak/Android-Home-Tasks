package com.example.androidhometasks.ht1.menu

import com.example.androidhometasks.ht1.taskSequentialInput.SequentialInputNumbersAndOperations

class Menu {
    fun printMenu(): Double {
        var flag = true;
        var result = 0.0
        do {
            println("\t---CALCULATOR---")
            println(
                "Варианты реализации:\n" +
                        "1.последовательный ввод \n" +
                        "2.парсинг выражения без скобок\n" +
                        "3.парсинг выражения со скобками\n" +
                        "4.Exit"
            )
            when (val value = readLine()) {
                "1" -> {
                    println("$value последовательный ввод")
                    result = SequentialInputNumbersAndOperations().getIntAndOperation()
                }
                "2" -> println("2")
                "3" -> println("3")
                "4" -> flag = false
                else -> println("Not")
            }
        } while (flag)
        return result
    }

}