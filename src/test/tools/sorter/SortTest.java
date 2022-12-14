package test.tools.sorter;

import com.yoj.grok.tools.sorter.Sort;
import com.yoj.grok.tools.sorter.sort_methods.Bubble;
import com.yoj.grok.tools.sorter.sort_methods.Heap;
import com.yoj.grok.tools.sorter.sort_methods.Insertion;
import com.yoj.grok.tools.sorter.sort_methods.Selection;
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
public class SortTest {

    private static String[] orderedWords;
    private static String[] unorderedWords;
    private static String[] sortedWords;

    private static ExtractorFromFile extractor;


    @BeforeAll
    static void arrange() throws IOException {
        extractor = TextExtractorFromFileProxy.getProxy("src\\com\\yoj\\grok\\texts\\ulysses.txt");
        orderedWords = extractor.extractArrayOfUniques(new TreeSet<>());

    }

    @BeforeEach
    public void act() throws IOException {
        unorderedWords = extractor.extractArrayOfUniques(new HashSet<>());
    }


    @Test
    public void testSelection(){
        sortedWords = Sort.of(unorderedWords).byMethod(new Selection());
        assertArrayEquals(orderedWords,sortedWords);
    }

    @Test
    public void testBubble(){
        sortedWords = Sort.of(unorderedWords).byMethod(new Bubble());
        assertArrayEquals(orderedWords,sortedWords);
    }

    @Test
    public void testInsertion(){
        sortedWords = Sort.of(unorderedWords).byMethod(new Insertion());
        assertArrayEquals(orderedWords,sortedWords);
    }

    @Test
    public void testHeap(){
        sortedWords = Sort.of(unorderedWords).byMethod(new Heap());
        assertArrayEquals(orderedWords,sortedWords);
    }





}
