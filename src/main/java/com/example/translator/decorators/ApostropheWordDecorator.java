package com.example.translator.decorators;

import com.example.translator.processors.WordProcessor;

public class ApostropheWordDecorator extends WordProcessor {

    private final WordProcessor processor;

    public ApostropheWordDecorator(WordProcessor processor) {
        this.processor = processor;
    }

    @Override
    public String process(String word) {
        if (shouldProcess(word)) {
            StringBuilder sb = new StringBuilder(processor.process(word).replaceAll("'", ""));

            for (int i = 0; i < word.length() && i <= sb.length(); i++) {
                if (word.charAt(word.length() - 1 - i) == '\'') {
                    sb.insert(sb.length() - i, "'");
                }
            }

            return sb.toString();
        }

        return processor.process(word);
    }

    @Override
    public boolean shouldProcess(String word) {
        return processor.shouldProcess(word);
    }
}
