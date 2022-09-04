package com.yoj.grok.sandbox;

import com.yoj.grok.tools.sorter.Sort;
import com.yoj.grok.tools.sorter.sort_methods.Heap;
import com.yoj.grok.tools.text_extractor.ExtractorFromFile;
import com.yoj.grok.tools.text_extractor.Proxy.TextExtractorFromFileProxy;


import java.io.*;
import java.util.*;


public class Sandbox {
    public static void main(String[] args) throws IOException {
        ExtractorFromFile JJoice = TextExtractorFromFileProxy.getProxy("src\\com\\yoj\\grok\\texts\\ulysses.txt");
        ExtractorFromFile HPLovecraft = TextExtractorFromFileProxy.getProxy("src\\com\\yoj\\grok\\texts\\the_dunwitch_horror.txt");
        ExtractorFromFile RLStevenson = TextExtractorFromFileProxy.getProxy("src\\com\\yoj\\grok\\texts\\the_strange_case_of_dr_jekyll_and_mr_hyde.txt");

        Set<String> uniqueWords = JJoice.extractSet(new HashSet<>());
//        System.out.println(uniqueWords);
//        System.out.println(uniqueWords.size());

        String[] wordsOrdered = JJoice.extractArrayOfUniques(new TreeSet<>());
        String[] wordsUnordered = JJoice.extractArrayOfUniques(new HashSet<>());
//        System.out.println(words.length);

        System.out.println("****************************************");


        String[] wordsSorted = Sort.of(wordsUnordered).byMethod(new Heap());

//        System.out.println(Arrays.toString(wordsSorted));
        System.out.println(Arrays.equals(wordsOrdered, wordsSorted));

//        printUniqueRatio(HPLovecraft, "The Dunwitch Horror");
//        printUniqueRatio(JJoice, "Ulysse");
//        printUniqueRatio(RLStevenson, "The Strange Case Of Dr. Jekyll And Mr. Hyde");

    }

    private static void printUniqueRatio(ExtractorFromFile extractor, String textName) throws IOException {
        String[] allWordsFromText = extractor.extractRawArray();
        String[] uniqueWordsFromText = extractor.extractArrayOfUniques(new TreeSet<>());
        System.out.println("unique words in " + textName + ": " + uniqueWordsFromText.length);
        float ratioLC = (float) uniqueWordsFromText.length / (float) allWordsFromText.length;
        System.out.println("unique words ratio in " + textName + ": " + ratioLC);
    }


}
