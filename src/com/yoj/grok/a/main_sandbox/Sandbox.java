package com.yoj.grok.a.main_sandbox;

import com.yoj.grok.tools.sorter.Sort;
import com.yoj.grok.tools.sorter.sort_methods.Heap;
import com.yoj.grok.tools.text_extractor.ExtractorFromFile;
import com.yoj.grok.tools.text_extractor.Proxy.TextExtractorFromFileProxy;


import java.io.*;
import java.util.*;


public class Sandbox {
    public static void main(String[] args) throws IOException {
        ExtractorFromFile Joice = TextExtractorFromFileProxy.getProxy("src\\com\\yoj\\grok\\ulysses\\ulysses.txt");
        ExtractorFromFile Lovecraft = TextExtractorFromFileProxy.getProxy("src\\com\\yoj\\grok\\ulysses\\the_dunwitch_horror.txt");

//        Set<String> uniqueWords = Joice.extractSet(new HashSet<>());
////        System.out.println(uniqueWords);
////        System.out.println(uniqueWords.size());
//
//        String[] wordsOrdered = Joice.extractArrayOfUniques(new TreeSet<>());
//        String[] wordsUnordered = Joice.extractArrayOfUniques(new HashSet<>());
////        System.out.println(words.length);
//
//        System.out.println("****************************************");
//
//
//        String[] wordsSorted = Sort.of(wordsUnordered).byMethod(new Heap());
//
////        System.out.println(Arrays.toString(wordsSorted));
//        System.out.println(Arrays.equals(wordsOrdered, wordsSorted));

        printUniqueRatio(Lovecraft, "The Dunwitch Horror");
        printUniqueRatio(Joice, "Ulysse");

    }

    private static void printUniqueRatio(ExtractorFromFile extractor, String textName) throws IOException {
        String[] allWordsFromText = extractor.extractRawArray();
        String[] uniqueWordsFromText = extractor.extractArrayOfUniques(new TreeSet<>());
        System.out.println("unique words in " + textName + ": " + uniqueWordsFromText.length);
        float ratioLC = (float) uniqueWordsFromText.length / (float) allWordsFromText.length;
        System.out.println("unique words ratio in " + textName + ": " + ratioLC);
    }


}
