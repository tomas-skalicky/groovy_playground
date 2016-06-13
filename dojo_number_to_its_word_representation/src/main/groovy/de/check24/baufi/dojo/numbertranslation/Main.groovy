package de.check24.baufi.dojo.numbertranslation

import java.sql.ResultSet;

import com.sun.org.apache.bcel.internal.generic.RETURN;

class Main {

    def static final ZERO = 'zero'
    def static final SINGLE_DIGIT_MAP = [
        1 : 'one',
        2 : 'two',
        3 : 'three',
        4 : 'four',
        5 : 'five',
        6 : 'six',
        7 : 'seven',
        8 : 'eight',
        9 : 'nine',
    ]
    def static final TENS_MAP = [
        1 : 'ten',
        2 : 'twenty',
        3 : 'thirty',
        4 : 'fourty',
        5 : 'fifty',
        6 : 'sixty',
        7 : 'seventy',
        8 : 'eighty',
        9 : 'ninety',
    ]
    def static final SPECIAL_TWO_DIGITS_MAP = [
        10 : 'ten',
        11 : 'eleven',
        12 : 'twelve',
        13 : 'thirdteen',
        14 : 'fourteen',
        15 : 'fifteen',
        16 : 'sixteen',
        17 : 'seventeen',
        18 : 'eighteen',
        19 : 'nineteen'
    ]
    def static final HUNDRED = "hundred"
    def static final THOUSAND = "thousand"


    def translate = { int number ->
        if (number == 0) {
            return ZERO
        }

        def result = new StringBuilder();


        int thousand = number / 1000
        if (thousand > 0) {
            addSpace(result)
            translateHundred(thousand, result)
            result.append(" ${THOUSAND}")
        }

        int numberRest = number % 1000
        translateHundred(numberRest, result)

        return result.toString()
    }

    def translateHundred = { int numberRest, StringBuilder result ->

        if (numberRest > 0 && result.size() > 0) {
            result.append(" and")
        }

        int hundreds = numberRest / 100
        if (hundreds > 0) {
            addSpace(result)
            result.append("${SINGLE_DIGIT_MAP[hundreds]} ${HUNDRED}")
        }

        numberRest = numberRest % 100
        if (numberRest > 0 && result.size() > 0) {
            result.append(" and")
        }

        int tens = numberRest / 10
        if (tens == 1) {
            addSpace(result)
            result.append(SPECIAL_TWO_DIGITS_MAP[numberRest])
            return
        }
        if (tens > 0) {
            addSpace(result)
            result.append(TENS_MAP[tens])
        }

        numberRest = numberRest % 10
        if (numberRest < 10 && numberRest > 0) {
            addSpace(result)
            result.append(SINGLE_DIGIT_MAP[numberRest])
        }
    }

    def addSpace = { StringBuilder result ->
        if (result.size() > 0) result.append(' ')
    }
}
