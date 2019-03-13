package com.example.translator

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import spock.lang.Specification
import spock.lang.Subject

@ActiveProfiles("test")
@SpringBootTest(classes = Application)
class PigLatinTranslatorIntegrationSpec extends Specification {

    @Subject
    @Autowired
    PigLatinTranslator translator

    def "should translate the string"() {
        when:
            String result = translator.translate("Hello, Apple stairway 'can't' end. This-thing, Beach, McCloud?")
        then:
            result == "Ellohay, Appleway stairway 'antca'y' endway. Histay-hingtay, Eachbay, CcLoudmay?"
    }

}
