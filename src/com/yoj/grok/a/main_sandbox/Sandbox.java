package com.yoj.grok.a.main_sandbox;

import com.yoj.grok.tools.sorter.Sort;
import com.yoj.grok.tools.sorter.sort_methods.Bubble;
import com.yoj.grok.tools.sorter.sort_methods.Insertion;
import com.yoj.grok.tools.sorter.sort_methods.Selection;
import com.yoj.grok.tools.text_extractor.ExtractorFromFile;
import com.yoj.grok.tools.text_extractor.Proxy.TextExtractorFromFileProxy;


import java.io.*;
import java.util.*;


public class Sandbox {
    public static void main(String[] args) throws IOException {

        long methodTimer = 0;

        ExtractorFromFile extractor = TextExtractorFromFileProxy.getProxy("src\\com\\yoj\\grok\\ulysses\\ulysses.txt");
        StringBuilder builder = extractor.extractClearedRawTextAsBuilder();


        Set<String> uniqueWords = extractor.extractAsSet(new HashSet<>());
//        System.out.println(uniqueWords);
//        System.out.println(uniqueWords.size());



        String[] wordsOrdered = extractor.extractAsArrayOfUniques(new TreeSet<>());
        String[] wordsUnordered = extractor.extractAsArrayOfUniques(new HashSet<>());
//        System.out.println(words.length);





        System.out.println("****************************************");

        String[] wordsSorted = Sort.of(wordsOrdered).byMethod(new Selection());

//        System.out.println(Arrays.toString(wordsSorted));


        System.out.println(Arrays.equals(wordsOrdered, wordsSorted));

    }

}
