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
        String[] sortedWords = new String[unsortedWords.length];




        printTotalOperations();
        printWorkingTime();
        return  sortedWords;
    }

    public static String[] bubbleMove(String[] pool){
        String[] alteredpool = pool;

        return alteredpool;
    }

    private static void printTotalOperations(){
        System.out.println("total operations: " + operations);
    }

    private static void printWorkingTime(){
        workingTime = new Date().getTime() - startTime;
        System.out.println("Selection total working time: " + workingTime + " ms");
    }
}
