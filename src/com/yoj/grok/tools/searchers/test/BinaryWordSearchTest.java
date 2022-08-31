package com.yoj.grok.tools.searchers.test;



import com.yoj.grok.tools.searchers.BinaryWordSearch;
import com.yoj.grok.tools.text_extractor.ExtractorFromFile;
import com.yoj.grok.tools.text_extractor.Proxy.TextExtractorFromFileProxy;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Random;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

@Nested
public class BinaryWordSearchTest {

    private static String[] words;
    private static int lastElem;
    private static final Random random = new Random();

    @BeforeAll
    public static void arrange() throws IOException {
        ExtractorFromFile extractor = TextExtractorFromFileProxy.getProxy("src\\com\\yoj\\grok\\ulysses\\ulysses.txt");
        words = extractor.extractAsArrayOfUniques(new TreeSet<>());
         lastElem = words.length - 1;


    }

    @Test
    public void testZeroLast(){
        assertEquals(0, BinaryWordSearch.in(words).find(words[0]));
        assertEquals(lastElem, BinaryWordSearch.in(words).find(words[lastElem]));
    }

    @Test
    public void testTenRandomElements(){
        for (int i = 0; i < 10; i++){
            int randomIndex = random.nextInt(lastElem);
            assertEquals(randomIndex, BinaryWordSearch.in(words).find(words[randomIndex]));
        }
    }

    @Test
    public void testNull(){
        assertThrows(IllegalArgumentException.class, () -> BinaryWordSearch.in(words).find(null));
        assertThrows(IllegalArgumentException.class, () -> BinaryWordSearch.in(null).find(null));
        assertThrows(IllegalArgumentException.class, () -> BinaryWordSearch.in(null));
    }

    @Test
    public void testEmpty(){
        assertEquals(-1, BinaryWordSearch.in(words).find(""));
    }

    @Test
    public void testMissing(){
        assertEquals(-1, BinaryWordSearch.in(words).find("iHopeThisIsNotInTheList"));
        assertEquals(-1, BinaryWordSearch.in(words).find("ThisIsDefinitelyNotInTheList"));
    }


}
