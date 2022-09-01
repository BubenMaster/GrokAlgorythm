package com.yoj.grok.tools.sorters.select_sort;


import java.util.Date;


public class SorterBySelection {

    private static int operations = 0;

    private static long startTime = 0;
    private static long workingTime = 0;

    public static String[] sort(String[] unsortedWords){
        startTime = new Date().getTime();

        String minWord = null;
        int minIndex = 0;

        String[] sortedWords = unsortedWords;

        for (int i = 0; i < sortedWords.length; i++){
            minIndex = findMinFrom(sortedWords, i);
            minWord = sortedWords[minIndex];
            sortedWords[minIndex] = sortedWords[i];
            sortedWords[i] = minWord;
        }

        printTotalOperations();
        printWorkingTime();
        return  sortedWords;
    }

    private static int findMinFrom(String[] pool, int startingIndex){
        int minIndex = startingIndex;
        String minWord = pool[minIndex];
        for (int i = startingIndex; i < pool.length; i++){
            operations++;
            String currentWord = pool[i];
            if(minWord.compareTo(currentWord) > 0) {
                minWord = currentWord;
                minIndex = i;
            }
        }
        return minIndex;
    }

    private static void printTotalOperations(){
        System.out.println("Selection total operations: " + operations);
    }

    private static void printWorkingTime(){
        workingTime = new Date().getTime() - startTime;
        System.out.println("Selection total working time: " + workingTime + " ms");
    }
}
