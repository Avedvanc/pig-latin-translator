package com.example.translator;

import org.springframework.stereotype.Service;

import com.example.translator.processors.WordProcessor;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PigLatinTranslator {

    private final WordProcessor processorChain;

    public String translate(String input) {
        String[] separated = input.split("\\b(?<!\\w')\\b(?!'\\w)");

        StringBuilder sb = new StringBuilder();

        for (String s : separated) {
            sb.append(processorChain.process(s));
        }

        return sb.toString();
    }

}
