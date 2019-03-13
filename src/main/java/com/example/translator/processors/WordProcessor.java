package com.example.translator.processors;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public abstract class WordProcessor {

    private WordProcessor nextProcessor;

    abstract public boolean shouldProcess(String word);

    abstract public String process(String word);

    String callNextProcessor(String word) {
        return nextProcessor != null ? nextProcessor.process(word) : word;
    }

}
