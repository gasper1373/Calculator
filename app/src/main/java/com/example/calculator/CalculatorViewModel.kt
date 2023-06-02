package com.example.calculator

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import java.lang.IllegalArgumentException

class CalculatorViewModel(): ViewModel() {

    private val display = mutableStateOf("0")

    private var previousOperator = ""

    private var prevOperand = ""

    fun handleNumbers(number: String) {
        if (display.value == "0") {
            display.value = number
        } else display.value += number
    }

    fun handleOperatorClick(operator: String) {
        if (previousOperator.isNotEmpty() && prevOperand.isNotEmpty()) {
            val result =
                calculate(prevOperand.toDouble(), display.value.toDouble(), previousOperator)
            display.value = result.toString()
            prevOperand = result.toString()
            previousOperator = ""
        }
    }

    fun reset() {
        display.value = "0"
        previousOperator = ""
        prevOperand = ""
    }

    private fun calculate(num1: Double, num2: Double, operator: String):Double{
        return when(operator){
            "+"-> num1 + num2
            "-"-> num1 - num2
            "*"-> num1 * num2
            "/"-> num1 / num2
            else -> {
                throw IllegalArgumentException("Invalid operator")
            }
        }
    }

}