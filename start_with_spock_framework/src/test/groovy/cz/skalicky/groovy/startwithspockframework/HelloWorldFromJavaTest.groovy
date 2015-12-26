package cz.skalicky.groovy.startwithspockframework

import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.Matchers.is

import org.junit.Test





class HelloWorldFromJavaTest {

    @Test
    def void testSayHelloWithoutSpock() {
        HelloWorldFromJava helloWorld = new HelloWorldFromJava()
        assertThat(helloWorld.sayHello('Tomas'), is('Java says: Hello Tomas'))
    }
}
