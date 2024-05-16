package org.example

import java.io.File

fun main() {

    val dictionaryFile: File = File("dictionary.txt")

    dictionaryFile.createNewFile()

    dictionaryFile.appendText("hello привет\n")
    dictionaryFile.appendText("dog собака\n")
    dictionaryFile.appendText("cat кошка\n")

    dictionaryFile.readLines().forEach {
        println(it)
    }

}