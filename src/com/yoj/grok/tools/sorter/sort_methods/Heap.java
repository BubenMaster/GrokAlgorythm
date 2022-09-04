package com.yoj.grok.tools.sorter.sort_methods;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Heap extends SortMethodWithMeasurePrototype{


    @Override
    public String[] sort(String[] unsortedWords) {

        String[] sortedWords = unsortedWords;
        int length = sortedWords.length;

        for(int i = length / 2 - 1; i>=0; i--){
            heapify(sortedWords, length, i);
        }

        for (int i = length-1; i>=0; i--){
            operations++;
            String buffer = sortedWords[i];
            sortedWords[i] = sortedWords[0];
            sortedWords[0] = buffer;

            heapify(sortedWords, i, 0);
        }

        return sortedWords;
    }

    public void heapify(String[] pool, int heapLength, int node){

        int largest = node;
        int right = node * 2 + 1;
        int left = node * 2 + 2;

        if (left <= heapLength - 1 && pool[left].compareTo(pool[largest]) > 0 ) {
            largest = left;
        }

        if (right <= heapLength - 1 && pool[right].compareTo(pool[largest]) > 0 ) {
            largest = right;
        }
        if (largest != node) {
            operations++;
            String buffer = pool[node];
            pool[node] = pool[largest];
            pool[largest] = buffer;

            heapify(pool, heapLength, largest);
        }
    }

}
