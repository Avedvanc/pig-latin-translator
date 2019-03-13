package com.example.translator.processors;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NonWordProcessor extends WordProcessor {

    public NonWordProcessor(WordProcessor nextProcessor) {
        super(nextProcessor);
    }

    @Override
    public String process(String word) {
        if (shouldProcess(word)) {
            return word;
        }
        return callNextProcessor(word);
    }

    @Override
    public boolean shouldProcess(String word) {
        return !word.matches("[a-zA-Z']+");
    }
}
