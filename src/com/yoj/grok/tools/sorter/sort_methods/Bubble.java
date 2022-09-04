package com.yoj.grok.tools.sorter.sort_methods;

import org.jetbrains.annotations.NotNull;

public class Bubble extends SortMethodWithMeasurePrototype{

    @NotNull
    public String[] sort(String[] unsortedWords) {
        String[] sortedWords = unsortedWords.clone();

        for (int i = 0; i < sortedWords.length; i++){
            bubbleMove(sortedWords, sortedWords.length - i);
        }
        return sortedWords;
    }

    private static void bubbleMove(String[] pool, int newLimit){
        String buffer;
        for (int i = 1; i < newLimit; i++){
            operations++;
            if (pool[i-1].compareTo(pool[i]) > 0) {
                 buffer = pool[i-1];
                 pool[i-1] = pool[i];
                 pool[i] = buffer;
            }
        }

    }
}
