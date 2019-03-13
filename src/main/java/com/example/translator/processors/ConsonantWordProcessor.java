package com.example.translator.processors;

import java.util.Arrays;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ConsonantWordProcessor extends WordProcessor {

    private static final char[] CONSONANTS = {'B','C','D','F','G','H','J','K','L','M','N','P','Q','R','S','T','V','W','X','Y','Z',
            'b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','w','x','y','z'};
    private static final String SUFFIX = "way";

    public ConsonantWordProcessor(WordProcessor nextProcessor) {
        super(nextProcessor);
    }

    @Override
    public String process(String word) {
        if (shouldProcess(word)) {
            StringBuilder sb = new StringBuilder();
            sb.append(word.substring(1));
            sb.append(word.charAt(0));
            sb.append("ay");
            return sb.toString();
        }
        return callNextProcessor(word);
    }

    @Override
    public boolean shouldProcess(String word) {
        return word != null
                && !word.isEmpty()
                && Arrays.binarySearch(CONSONANTS, word.charAt(0)) >= 0
                && !(word.length() > 3 && word.substring(word.length() - 3).equals(SUFFIX));
    }

}
