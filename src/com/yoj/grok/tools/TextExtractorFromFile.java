package com.yoj.grok.tools;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class TextExtractorFromFile {

    String fileDir;
    private static  final String  SPACE = String.valueOf('\u0020');


    public TextExtractorFromFile(String fileDir) {
        this.fileDir = fileDir;
    }

    public StringBuilder extractAsBuilder() throws IOException {
        File file = new File(fileDir);
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        StringBuilder builder = new StringBuilder();
        String line;
        while ( (line = reader.readLine()) != null) {
            builder.append(StringLineClearer.clearAllExceptLettersAndSingleWhiteSpacesIn(!line.isEmpty() ? line + SPACE : ""));
        }

        return builder;
    }

    public Set<String> extractAsSet(Set<String> setWithDesiredType) throws IOException {
        setWithDesiredType.clear();
        
        String[] words = extractAsBuilder().toString().split(SPACE);         
        for (int i = 0; i < words.length; i++) {
            if (!words[i].isEmpty()) setWithDesiredType.add(words[i].toLowerCase());
        }
        return  setWithDesiredType;
    }

    public String[] extractAsArrayOfUniques(Set<String> setWithDesiredType) throws IOException {
        setWithDesiredType.clear();
        String[] words = extractAsBuilder().toString().split(SPACE);
        int length = 0;
        for (int i = 0; i < words.length; i++) {
            if (!words[i].isEmpty()) setWithDesiredType.add(words[i].toLowerCase());
        }
        String[] uniqueWords = new String[setWithDesiredType.size()];

        int i = 0;
        for (String word: setWithDesiredType){
            uniqueWords[i++] = word;
        }


        return uniqueWords;
    }

}
