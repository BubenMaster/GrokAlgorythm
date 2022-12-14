package com.yoj.grok.tools.sorter.sort_methods;

import org.jetbrains.annotations.NotNull;

import java.util.Date;

public abstract class SortMethodWithMeasurePrototype implements SortMethod {

    protected static int operations = 0;

    private static long startTime = 0;
    private static long workingTime = 0;

    public String[] sortWithMeasure(String[] unsortedWords){
        startTime = new Date().getTime();
        operations = 0;

        String[] sortedWords = sort(unsortedWords);

        printTotalOperations();
        printWorkingTime();
        return  sortedWords;
    }




    private void printTotalOperations(){
        System.out.println(this.getClass().getSimpleName() +" total operations: " + operations);
    }

    private void printWorkingTime(){
        workingTime = new Date().getTime() - startTime;
        System.out.println(this.getClass().getSimpleName() + "Selection total working time: " + workingTime + " ms");
    }
}
