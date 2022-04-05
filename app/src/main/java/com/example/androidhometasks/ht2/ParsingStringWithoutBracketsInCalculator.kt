package com.example.androidhometasks.ht2

import com.example.androidhometasks.ht1.taskParsingWithoutBrackets.ParsingStringWithoutBrackets

class ParsingStringWithoutBracketsInCalculator(private val string: String) :
    ParsingStringWithoutBrackets() {

    override fun getInputString(): List<String> {
        return formattingInputString(string)
    }

}