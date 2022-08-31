package com.yoj.grok.binary.word_search;

import com.yoj.grok.tools.searchers.BinaryWordSearch;
import com.yoj.grok.tools.text_extractor.ExtractorFromFile;
import com.yoj.grok.tools.text_extractor.Proxy.TextExtractorFromFileProxy;
import com.yoj.grok.tools.text_extractor.string_clearer.StringLineClearer;
import org.junit.jupiter.params.shadow.com.univocity.parsers.conversions.RegexConversion;


import java.io.*;
import java.util.*;
import java.util.regex.Pattern;


public class WordSearch {
    public static void main(String[] args) throws IOException {

        long methodTimer = 0;

        ExtractorFromFile extractor = TextExtractorFromFileProxy.getProxy("src\\com\\yoj\\grok\\ulysses\\ulysses.txt");
        StringBuilder builder = extractor.extractClearedRawTextAsBuilder();


        Set<String> uniqueWords = extractor.extractAsSet(new HashSet<>());
        System.out.println(uniqueWords);
        System.out.println(uniqueWords.size());

        System.out.println("****************************************");

        String[] words = extractor.extractAsArrayOfUniques(new TreeSet<>());
        System.out.println(words.length);

        System.out.println("founded index: " + BinaryWordSearch.in(words).find("honey"));
    }

}
