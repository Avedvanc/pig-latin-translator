package com.example.translator.decorators;

import com.example.translator.processors.WordProcessor;

public class CapitalizationWordDecorator extends WordProcessor {

    private final WordProcessor processor;

    public CapitalizationWordDecorator(WordProcessor processor) {
        this.processor = processor;
    }

    @Override
    public String process(String word) {
        if (shouldProcess(word)) {
            char[] a = word.toCharArray();
            char[] b = processor.process(word).toLowerCase().toCharArray();

            int count = 0;
            while (count < a.length && count < b.length) {
                if (Character.isUpperCase(a[count])) {
                    b[count] = Character.toUpperCase(b[count]);
                }
                count++;
            }

            return new String(b);
        }

        return processor.process(word);
    }

    @Override
    public boolean shouldProcess(String word) {
        return processor.shouldProcess(word);
    }
}
