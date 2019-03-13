package com.example.translator.decorators


import com.example.translator.processors.WordProcessor
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

@Unroll
class ApostropheWordDecoratorSpec extends Specification {

    WordProcessor processor = Mock(WordProcessor)

    @Subject
    ApostropheWordDecorator decorator = new ApostropheWordDecorator(processor)

    def "should call processor when shouldProcess() is invoked" () {
        when:
            decorator.shouldProcess('new')
        then:
            1 * processor.shouldProcess('new')
    }

    def "should return #expected when process #word if processor returned #processedWord" () {
        given:
            processor.shouldProcess(word) >> true
        when:
            String result = decorator.process(word)
        then:
            result == expected
            1 * processor.process(word) >> processedWord
        where:
            word        | processedWord || expected
            "new'"      | "abcdrf"      || "abcdrf'"
            "sig'way"   | "newword"     || "neww'ord"
            "A'bc"      | "processed"   || "process'ed"
            "eb'f"      | "a'eway"      || "aewa'y"
    }

}
