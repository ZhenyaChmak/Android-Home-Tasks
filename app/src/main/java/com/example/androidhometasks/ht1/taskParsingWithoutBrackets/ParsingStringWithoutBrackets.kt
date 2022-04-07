package com.example.androidhometasks.ht1.taskParsingWithoutBrackets

import com.example.androidhometasks.ht1.myInterface.ParsingString
import java.lang.Exception

open class ParsingStringWithoutBrackets : ParsingString {

    override fun resultSum(): Double {
        val list = getInputString()
        var counter = 0
        var resultSum = 0.0
        val tempListString = mutableListOf<String>()
        for (i in list.indices) {

            if (i == 0) {
                tempListString.add(list[i])
                ++counter
                continue
            }

            if (list[i] == "+" || list[i] == "-") {
                if (i == list.size - 2 || list[i + 2] != "*" && list[i + 2] != "/") {
                    resultSum = when (list[i]) {
                        "+" -> tempListString[counter - 1].toDouble() + list[i + 1].toDouble()
                        "-" -> tempListString[counter - 1].toDouble() - list[i + 1].toDouble()
                        else -> 0.0
                    }
                    tempListString[counter - 1] = resultSum.toString()
                } else {
                    tempListString.add(list[i])
                    tempListString.add(list[i + 1])
                    counter += 2
                }
                continue
            }

            if (list[i] == "*" || list[i] == "/") {
                if (list[i] == "/" && list[i + 1] == "0") {
                    throw Exception("Деление на 0")
                } else {
                    resultSum = when (list[i]) {
                        "*" -> tempListString[counter - 1].toDouble() * list[i + 1].toDouble()
                        "/" -> tempListString[counter - 1].toDouble() / list[i + 1].toDouble()
                        else -> 0.0
                    }
                    tempListString[counter - 1] = resultSum.toString()
                }
                continue
            }

            if ((counter > 2 && i == list.size - 1) || (counter > 2 && list[i + 1] != "*" && list[i + 1] != "/")) {
                resultSum = when (tempListString[counter - 2]) {
                    "+" -> tempListString[counter - 3].toDouble() + tempListString[counter - 1].toDouble()
                    "-" -> tempListString[counter - 3].toDouble() - tempListString[counter - 1].toDouble()
                    else -> 0.0
                }
                counter = 0
                tempListString.clear()
                tempListString.add(resultSum.toString())
                counter++
            }
        }

        //  println("сумма = $resultSum")
        //  println("----------------------------------")
        return resultSum
    }

    protected open fun getInputString(): List<String> {
        println("Введите строку:")
        val string: String = readLine().toString()
        return formattingInputString(string)
    }

    open fun formattingInputString(value: String): List<String> {
        value.replace(" ", "")
        val string = mutableListOf<String>()
        var tempString = ""
        val arrayOperations = charArrayOf('+', '-', '*', '/')
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
        if (tempString != "") {
            string.add(tempString)
        }
        return string
    }

 }