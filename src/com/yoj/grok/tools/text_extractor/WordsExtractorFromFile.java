package com.yoj.grok.tools.text_extractor;

import com.yoj.grok.tools.text_extractor.string_clearer.StringLineClearer;

import java.io.*;
import java.util.Set;

public class WordsExtractorFromFile implements ExtractorFromFile {

    private long methodExecutionTime = 0;
    private final String fileDir;
    private static  final String  SPACE = String.valueOf('\u0020');


    public WordsExtractorFromFile(String fileDir) {
        this.fileDir = fileDir;
    }

    @Override
    public long getMethodExecutionTime() {
        return this.methodExecutionTime;
    }

    @Override
    public void setMethodExecutionTime(long timeRecord) {
        this.methodExecutionTime = timeRecord;
    }

    @Override
    public StringBuilder extractRawWordsBuilder() throws IOException {
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
            builder.append(StringLineClearer.clearNotWords(!line.isEmpty() ? line + SPACE : ""));
        }

        return builder;
    }

    @Override
    public Set<String> extractSet(Set<String> setWithDesiredType) throws IOException {
        setWithDesiredType.clear();
        
        String[] words = extractRawArray();
        for (int i = 0; i < words.length; i++) {
            if (!words[i].isEmpty()) setWithDesiredType.add(words[i].toLowerCase());
        }
        return  setWithDesiredType;
    }

    @Override
    public String[] extractArrayOfUniques(Set<String> setWithDesiredType) throws IOException {
        setWithDesiredType.clear();

        String[] words = extractRawArray();
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

    @Override
    public String[] extractRawArray() throws IOException {
        String[] allWords = extractRawWordsBuilder().toString().replaceAll(" +", " ").split(SPACE);
        return allWords;
    }

}
