package com.yoj.grok.tools.sorters.select_sort.test;

import com.yoj.grok.tools.sorters.select_sort.SorterBySelection;
import com.yoj.grok.tools.text_extractor.ExtractorFromFile;
import com.yoj.grok.tools.text_extractor.Proxy.TextExtractorFromFileProxy;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashSet;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

@Nested
public class SorterBySelectionTest {

    private static String[] orderedWords;
    private static String[] unorderedWords;
    private static String[] sortedWords;


    @BeforeAll
    static void arrange() throws IOException {
        ExtractorFromFile extractor = TextExtractorFromFileProxy.getProxy("src\\com\\yoj\\grok\\ulysses\\ulysses.txt");
        orderedWords = extractor.extractAsArrayOfUniques(new TreeSet<>());
        unorderedWords = extractor.extractAsArrayOfUniques(new HashSet<>());
    }

    @BeforeEach
    public void act(){
        sortedWords = SorterBySelection.sort(unorderedWords);
    }


    @Test
    public void testSort(){
        assertArrayEquals(orderedWords,sortedWords);
    }

}
