package com.yoj.grok.binary.word_search;

import com.yoj.grok.tools.text_extractor.ExtractorFromFile;
import com.yoj.grok.tools.text_extractor.Proxy.TextExtractorFromFileProxy;


import java.io.*;
import java.util.*;

public class WordSearch {
    public static void main(String[] args) throws IOException {

        long methodTimer = 0;

        ExtractorFromFile extractor = TextExtractorFromFileProxy.getProxy("src\\com\\yoj\\grok\\ulysses\\ulysses.txt");
        StringBuilder builder = extractor.extractClearedRawTextAsBuilder();


        Set<String> uniqueWords = extractor.extractAsSet(new HashSet<>());

        System.out.println("****************************************");

        String[] words = extractor.extractAsArrayOfUniques(new TreeSet<>());
        System.out.println(words.length);


        String wordToFind = "wind";


        String min = words[0];
        int maxIndex = words.length - 1;
        int middleIndex = maxIndex/2;
        int minIndex = 0;
        int step = 0;

        while (minIndex < maxIndex){
            System.out.println("step" + ++step );
            if (wordToFind.equalsIgnoreCase(words[middleIndex])) {
                System.out.println("indexof word " + wordToFind + " is: " + middleIndex);
                break;
            }

            if (wordToFind.compareTo(words[middleIndex]) < 0){
                maxIndex = middleIndex;
            }
            else minIndex = middleIndex + 1;

            middleIndex = (maxIndex + minIndex)/2;
            System.out.println(middleIndex);
            System.out.println("Min: " + minIndex + " Max:  " + maxIndex);
        }

        System.out.println(words[middleIndex-1] + " " + words[middleIndex] + " " + words[middleIndex + 1]);



    }
}
