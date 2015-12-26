package cz.skalicky.groovy.startwithspockframework

import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.Matchers.is

import org.junit.Test

import spock.lang.Specification





class HelloWorldFromGroovyWithSpockTest extends Specification {

    @Test
    def "test say hello with Spock"() {
        def helloWorld = new HelloWorldFromGroovy()
        expect:
            helloWorld.sayHello(name) == result
            
        where:
            name    || result
            'Hana'  || 'Groovy says: Hello Hana'
            'Tomas' || 'Groovy says: Hello Tomas'
    }
}
