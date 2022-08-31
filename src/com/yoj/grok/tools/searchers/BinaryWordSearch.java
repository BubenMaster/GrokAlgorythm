package com.yoj.grok.tools.searchers;

import org.jetbrains.annotations.NotNull;

public class BinaryWordSearch {

    String[] words;

    private BinaryWordSearch(@NotNull String[] stringArray) {
        this.words = stringArray;
    }

    public static BinaryWordSearch in(String[] stringArray){
        return new BinaryWordSearch(stringArray);
    }


    /**
     * Seek typed word in the attached array and returns its index, or {@code -1} if not found.
     * @param word the word to find.
     * @return index of the word if it founded, otherwise {@code -1}.
     */
    public int find(@NotNull String word){
        String wordToFind = word.toLowerCase();

        int maxIndex = words.length - 1;
        int middleIndex = maxIndex/2;
        int minIndex = 0;

        while (minIndex < maxIndex){
            if (wordToFind.equals(words[middleIndex])) {
                break;
            }
            if (wordToFind.compareTo(words[middleIndex]) < 0){
                maxIndex = middleIndex - 1;
            }
            else minIndex = middleIndex + 1;
            middleIndex = (maxIndex + minIndex)/2;
        }

        return wordToFind.equals(words[middleIndex]) ? middleIndex : -1;
    }
}
