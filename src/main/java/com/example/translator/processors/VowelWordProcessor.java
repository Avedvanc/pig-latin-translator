package com.example.translator.processors;

import java.util.Arrays;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class VowelWordProcessor extends WordProcessor {

    private static final char[] VOWELS = {'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'};
    private static final String SUFFIX = "way";

    public VowelWordProcessor(WordProcessor nextProcessor) {
        super(nextProcessor);
    }

    @Override
    public String process(String word) {
        if (shouldProcess(word)) {
            return word + SUFFIX;
        }
        return callNextProcessor(word);
    }

    @Override
    public boolean shouldProcess(String word) {
        return word != null
                && !word.isEmpty()
                && Arrays.binarySearch(VOWELS, word.charAt(0)) >= 0;
    }

}
