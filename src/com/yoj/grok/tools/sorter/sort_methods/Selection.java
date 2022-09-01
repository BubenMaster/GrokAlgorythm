package com.yoj.grok.tools.sorter.sort_methods;


import org.jetbrains.annotations.NotNull;

import java.util.Date;


public class Selection extends SortMethodWithMeasurePrototype{


    @NotNull
    public String[] sort(String[] unsortedWords) {
        String[] sortedWords = unsortedWords.clone();

        for (int i = 0; i < sortedWords.length; i++){
            int minIndex = findMinFrom(sortedWords, i);
            String minWord = sortedWords[minIndex];
            sortedWords[minIndex] = sortedWords[i];
            sortedWords[i] = minWord;
        }
        return sortedWords;
    }

    private int findMinFrom(String[] pool, int startingIndex){
        int minIndex = startingIndex;
        String minWord = pool[minIndex];
        for (int i = startingIndex; i < pool.length; i++){
            super.operations++;
            String currentWord = pool[i];
            if(minWord.compareTo(currentWord) > 0) {
                minWord = currentWord;
                minIndex = i;
            }
        }
        return minIndex;
    }


}
