package com.example.translator.processors

import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

@Unroll
class NonWordProcessorSpec extends Specification {

    @Subject
    NonWordProcessor processor = new NonWordProcessor()

    def "should #shouldOrNot process '#word'" () {
        when:
            boolean result = processor.shouldProcess(word)
        then:
            result == expected
        where:
            word        || expected
            "new"       || false
            "don't"     || false
            "Children'" || false
            ""          || true
            "  "        || true
            "123"       || true
            "@#5"       || true
            shouldOrNot = expected ? '' : 'not'
    }

    def "should return #expected when process #word" () {
        given:
            processor = new NonWordProcessor(new TestProcessor())
        when:
            String result = processor.process(word)
        then:
            result == expected
        where:
            word        || expected
            "new"       || "abc"
            "123"       || "123"
            "~*&^"      || "~*&^"
    }

    static class TestProcessor extends WordProcessor {

        @Override
        boolean shouldProcess(String word) {
            return true
        }

        @Override
        String process(String word) {
            return 'abc'
        }
    }

}
