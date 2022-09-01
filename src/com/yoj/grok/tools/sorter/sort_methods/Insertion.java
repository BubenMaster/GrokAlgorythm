package com.yoj.grok.tools.sorter.sort_methods;

import org.jetbrains.annotations.NotNull;

import java.util.Date;

public class Insertion extends SortMethodWithMeasurePrototype{
    private static int operations = 0;
    private static long workingTime;
    private static long startTime;

    @NotNull
    public String[] sort(String[] unsortedWords) {
        String[] sortedWords = unsortedWords.clone();

        for(int i = 1; i < sortedWords.length; i++){
            keyWay(sortedWords, i);
        }
        return sortedWords;
    }

    private static void keyWay(String[] pool, int keyIndex) {
        String keyValue = pool[keyIndex];
        int endIndex = keyIndex;
        while (endIndex > 0 && keyValue.compareTo(pool[endIndex-1]) < 0){
            operations++;
            pool[endIndex] = pool[endIndex-1];
            endIndex--;
        }
        pool[endIndex] = keyValue;
    }
}
