package de.check24.baufi.dojo.numbertranslation

import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.Matchers.is

import org.junit.Test

import spock.lang.Specification


class MainTest extends Specification {

    @Test
    def "test translation"() {
        def main = new Main()

        expect:
        main.translate(number) == translatedNumber

        where:
        number    || translatedNumber
        //745       || 'seven hundred and fourty five'
        //1337      || 'one thousend three hundred and thirty seven'
        0         || 'zero'
        2         || 'two'
        5         || 'five'
        19        || 'nineteen'
        20        || 'twenty'
        21        || 'twenty one'
        100       || 'one hundred'
        101       || 'one hundred and one'
        110       || 'one hundred and ten'
        131       || 'one hundred and thirty one'
        999       || 'nine hundred and ninety nine'
        745       || 'seven hundred and fourty five'
        1745      || 'one thousand and seven hundred and fourty five'
        10745     || 'ten thousand and seven hundred and fourty five'
        11745     || 'eleven thousand and seven hundred and fourty five'
        756112    || 'seven hundred and fifty six thousand and one hundred and twelve'
    }
}
