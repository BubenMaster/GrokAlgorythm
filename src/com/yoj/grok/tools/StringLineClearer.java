package com.yoj.grok.tools;

public class StringLineClearer {

    public static String clearAllExceptLettersAndSingleWhiteSpacesIn(String line){
        line = line.replaceAll("[^[a-zA-Z_ ]]", "");
        line = line.replaceAll(" +", " ");
        line = line.replaceAll("_", " ");
        return (!line.isBlank()) ? line : "";
    }
}
