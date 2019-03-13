package com.example.translator.processors

import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

@Unroll
class VowelWordProcessorSpec extends Specification {

    @Subject
    VowelWordProcessor processor = new VowelWordProcessor()

    def "should #shouldOrNot process '#word'" () {
        when:
            boolean result = processor.shouldProcess(word)
        then:
            result == expected
        where:
            word        || expected
            "Abc"       || true
            "ebg"       || true
            "NeW"       || false
            "Word"      || false
            "new"       || false
            "don't"     || false
            "Children'" || false
            ""          || false
            "  "        || false
            "123"       || false
            "@#5"       || false
            shouldOrNot = expected ? '' : 'not'
    }

    def "should return #expected when process #word" () {
        given:
        processor = new VowelWordProcessor(new TestProcessor())
        when:
        String result = processor.process(word)
        then:
        result == expected
        where:
        word        || expected
        "new"       || "abc"
        "Abc"       || "Abcway"
        "ebf"       || "ebfway"
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
