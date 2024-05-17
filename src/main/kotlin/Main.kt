package org.example

import java.io.File

data class Word(
    val original: String,
    val translate: String,
    val correctAnswersCount: Int = 0,
)

fun main() {

    val dictionaryFile = File("dictionary.txt")
    val dictionary: MutableList<Word> = mutableListOf()
    val lines: List<String> = dictionaryFile.readLines()

    for (line in lines) {
        val listOfLine = line.split("|")
        dictionary.add(Word(listOfLine[0], listOfLine[1], listOfLine[2].toInt() ?: 0))
    }

    dictionary.forEach {
        println(it)
    }

}