package br.com.gdarlan.math

import kotlin.math.sqrt

class SimpleMath {

    fun sum(numberOne: Double, numberTwo: Double) = numberOne + numberTwo
    fun subtract(numberOne: Double, numberTwo: Double) = numberOne - numberTwo
    fun multiply(numberOne: Double, numberTwo: Double) = numberOne * numberTwo
    fun division(numberOne: Double, numberTwo: Double) = numberOne / numberTwo
    fun avg(numberOne: Double, numberTwo: Double): Double = listOf(numberOne, numberTwo).average()
    fun squareRoot(number: Double) = sqrt(number)
}