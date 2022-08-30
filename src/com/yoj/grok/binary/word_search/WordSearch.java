package com.yoj.grok.binary.word_search;

import com.yoj.grok.tools.TextExtractorFromFile;

import java.io.*;
import java.util.*;

public class WordSearch {
    public static void main(String[] args) throws IOException {

        TextExtractorFromFile extractor = new TextExtractorFromFile("src\\com\\yoj\\grok\\ulysses\\ulysses.txt");
        StringBuilder builder = extractor.extractAsBuilder();

        Date dateStart = new Date();
        Set<String> uniqueWords = extractor.extractAsSet(new HashSet<>());
        long dateDifference = new Date().getTime() - dateStart.getTime();
        System.out.println(dateDifference);

//        System.out.println(uniqueWords);
        System.out.println(uniqueWords.size());
        System.out.println("****************************************");

        String[] wordsUnique = extractor.extractAsArrayOfUniques(new HashSet<>());
        System.out.println(Arrays.toString(wordsUnique));
        System.out.println(wordsUnique.length);




//        System.out.println(uniqueWords);


    }
}
