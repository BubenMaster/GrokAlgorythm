package com.yoj.grok.tools.sorters.select_sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class SorterByBubble {

    private static int operations = 0;
    private static long workingTime;
    private static long startTime;

    public static String[] sort(String[] unsortedWords){
        startTime = new Date().getTime();
        String[] sortedWords = unsortedWords;

        for (int i = 0; i < sortedWords.length; i++){
            bubbleMove(sortedWords, sortedWords.length - i);
        }

        printTotalOperations();
        printWorkingTime();
        return  sortedWords;
    }

    private static void bubbleMove(String[] pool, int newLimit){
        String buffer;
        for (int i = 1; i < newLimit; i++){
            if (pool[i-1].compareTo(pool[i]) > 0) {
                operations++;
                 buffer = pool[i-1];
                 pool[i-1] = pool[i];
                 pool[i] = buffer;
            }
        }

    }

    private static void printTotalOperations(){
        System.out.println("total operations: " + operations);
    }

    private static void printWorkingTime(){
        workingTime = new Date().getTime() - startTime;
        System.out.println("Selection total working time: " + workingTime + " ms");
    }
}
