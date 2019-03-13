package com.example.translator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.translator.decorators.ApostropheWordDecorator;
import com.example.translator.decorators.CapitalizationWordDecorator;
import com.example.translator.processors.ConsonantWordProcessor;
import com.example.translator.processors.NonWordProcessor;
import com.example.translator.processors.VowelWordProcessor;
import com.example.translator.processors.WordProcessor;

@Configuration
public class TranslatorConfiguration {

    @Bean
    public WordProcessor pigLatinWordProcessorChain() {
        final WordProcessor consonantWordProcessor = new CapitalizationWordDecorator(new ApostropheWordDecorator(new ConsonantWordProcessor()));
        final WordProcessor vowelWordProcessor = new CapitalizationWordDecorator(new ApostropheWordDecorator(new VowelWordProcessor(consonantWordProcessor)));
        return new NonWordProcessor(vowelWordProcessor);
    }

}
