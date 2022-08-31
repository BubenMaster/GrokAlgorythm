package com.yoj.grok.tools.sorters.select_sort;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SelectSorter {

    private static int operations = 0;

    public static String[] sort(String[] unsortedWords){
        String[] sortedWords = new String[unsortedWords.length];
        List<String> remainWords = new ArrayList<>(Arrays.stream(unsortedWords).toList());

        for (int i = 0; i < sortedWords.length; i++){
            operations++;
            sortedWords[i] = findMinFrom(remainWords.toArray(new String[0]));
            remainWords.remove(sortedWords[i]);
        }

        System.out.println("total operations: " + operations);
        return  sortedWords;
    }

    private static String findMinFrom(String[] pool){
        String minWord = pool[0].toLowerCase();
        for (int i = 0; i < pool.length; i++){
            operations++;
            String currentWord = pool[i].toLowerCase();
            if(minWord.compareTo(currentWord) > 0) {
                minWord = currentWord;
            }
        }
        return minWord;
    }
}
