package com.yoj.grok.tools.text_extractor.string_clearer;

import java.util.ArrayList;
import java.util.List;

public class StringLineClearer {

    public static String clearNotWords(String line){
        line = line.replaceAll("[^[a-zA-Z ]]", " ");
        line = line.replaceAll(" +", " ");

        return (!line.isBlank()) ? line : "";
    }

}
