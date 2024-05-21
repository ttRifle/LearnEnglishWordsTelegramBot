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

    while (true) {

        println("Меню: 1 – Учить слова, 2 – Статистика, 0 – Выход")

        when (readln().toInt()) {
            1 -> {

                val notLearnedWords = dictionary.filter { it.correctAnswersCount < CORRECT_ANSWERS_TO_LEARN }

                while (notLearnedWords.isNotEmpty()) {

                    val answerWords = notLearnedWords.shuffled().take(NUMBER_OF_ANSWER_OPTIONS)
                    val wordToLearn = answerWords.random()

                    println(wordToLearn.original)
                    println(answerWords.joinToString { (answerWords.indexOf(it) + 1).toString() + " - " + it.translate })

                    when (readln().toInt()) {
                        0 -> break
                        else -> println("Не корректный выбор")
                    }

                }

                if (notLearnedWords.isEmpty()) println("Вы выучили все слова")

            }

            2 -> {

                val learnedWord = dictionary.filter { it.correctAnswersCount >= 3 }.size
                val numberOfWords = dictionary.size
                val percentOfLearnedWords = (learnedWord.toDouble() / numberOfWords.toDouble() * 100).toInt()

                println("Выучено $learnedWord из $numberOfWords слов | $percentOfLearnedWords%")

            }

            0 -> break
            else -> println("Не корректный выбор меню")
        }

    }

}

const val CORRECT_ANSWERS_TO_LEARN = 3
const val NUMBER_OF_ANSWER_OPTIONS = 4