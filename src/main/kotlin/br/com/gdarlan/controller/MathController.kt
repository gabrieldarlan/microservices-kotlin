package br.com.gdarlan.controller

import br.com.gdarlan.converters.NumberConverter
import br.com.gdarlan.exceptions.UnsurpotedMathOperationException
import br.com.gdarlan.math.SimpleMath
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
class MathController {

    val counter: AtomicLong = AtomicLong()
    private val math: SimpleMath = SimpleMath()

    @GetMapping(value = ["/sum/{numberOne}/{numberTwo}"])
    fun sum(
        @PathVariable(value = "numberOne") numberOne: String?,
        @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
            throw UnsurpotedMathOperationException(exception = "Please set a number valid")
        return math.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo))

    }

    @GetMapping(value = ["/subtract/{numberOne}/{numberTwo}"])
    fun subtract(
        @PathVariable(value = "numberOne") numberOne: String?,
        @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
            throw UnsurpotedMathOperationException(exception = "Please set a number valid")
        return math.subtract(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo))

    }

    @GetMapping(value = ["/multiply/{numberOne}/{numberTwo}"])
    fun multiply(
        @PathVariable(value = "numberOne") numberOne: String?,
        @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
            throw UnsurpotedMathOperationException(exception = "Please set a number valid")
        return math.multiply(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo))

    }

    @GetMapping(value = ["/division/{numberOne}/{numberTwo}"])
    fun division(
        @PathVariable(value = "numberOne") numberOne: String?,
        @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw UnsurpotedMathOperationException(exception = "Please set a number valid")
        }

        val resposta = math.division(
            NumberConverter.convertToDouble(numberOne),
            NumberConverter.convertToDouble(numberTwo)
        )
        return if (!resposta.isInfinite()) {
            resposta
        } else {
            throw UnsurpotedMathOperationException(exception = "Please set a number valid")
        }

    }

    @GetMapping(value = ["/avg/{numberOne}/{numberTwo}"])
    fun avg(
        @PathVariable(value = "numberOne") numberOne: String?,
        @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw UnsurpotedMathOperationException(exception = "Please set a number valid")
        }

        return math.avg(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo))
    }


    @GetMapping(value = ["/sqrt/{numberOne}"])
    fun squareRoot(
        @PathVariable(value = "numberOne") numberOne: String?,
    ): Double {
        if (!NumberConverter.isNumeric(numberOne)) {
            throw UnsurpotedMathOperationException(exception = "Please set a number valid")
        }
        return math.squareRoot(NumberConverter.convertToDouble(numberOne))
    }


}