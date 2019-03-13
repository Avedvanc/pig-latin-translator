package com.example.translator.processors

import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

@Unroll
class ConsonantWordProcessorSpec extends Specification {

    @Subject
    ConsonantWordProcessor processor = new ConsonantWordProcessor()

    def "should #shouldOrNot process '#word'" () {
        when:
            boolean result = processor.shouldProcess(word)
        then:
            result == expected
        where:
            word        || expected
            "NeW"       || true
            "Word"      || true
            "new"       || true
            "don't"     || true
            "Children'" || true
            "Abc"       || false
            "ebg"       || false
            ""          || false
            "  "        || false
            "123"       || false
            "@#5"       || false
            shouldOrNot = expected ? '' : 'not'
    }

    def "should return #expected when process #word" () {
        when:
            String result = processor.process(word)
        then:
            result == expected
        where:
            word        || expected
            "new"       || "ewnay"
            "sigway"    || "sigway"
            "Abc"       || "Abc"
            "ebf"       || "ebf"
    }

}
