package com.example.androidhometasks.ht1.menu

import com.example.androidhometasks.ht1.myInterface.ParsingString
import com.example.androidhometasks.ht1.taskParsingFromBrackets.ParsingStringFromBrackets
import com.example.androidhometasks.ht1.taskParsingWithoutBrackets.ParsingStringWithoutBrackets
import com.example.androidhometasks.ht1.taskSequentialInput.SequentialInputNumbersAndOperations

class Menu {

    fun printMenu(): Double {
        var flag = true;
        var result = 0.0
        var parsingString: ParsingString
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
                    println("$value. последовательный ввод")
                    result = SequentialInputNumbersAndOperations().getIntAndOperation()
                }
                "2" -> {
                    println("$value. парсинг выражения без скобок")
                    parsingString = ParsingStringWithoutBrackets()
                    result = parsingString.resultSum()
                }
                "3" -> {
                    println("$value. парсинг выражения со скобками")
                    parsingString = ParsingStringFromBrackets()
                    result = parsingString.resultSum()
                }
                "4" -> flag = false
                else -> println("Not")
            }
        } while (flag)
        return result
    }

}