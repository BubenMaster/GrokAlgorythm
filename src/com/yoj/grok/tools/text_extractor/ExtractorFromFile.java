package com.yoj.grok.tools.text_extractor;

import java.io.IOException;
import java.util.Set;

public interface ExtractorFromFile {
    long getMethodExecutionTime();
    void setMethodExecutionTime(long timeRecord);


    StringBuilder extractRawWordsBuilder() throws IOException;
    Set<String> extractSet(Set<String> setWithDesiredType) throws IOException;
    String[] extractArrayOfUniques(Set<String> setWithDesiredType) throws IOException;
    String[] extractRawArray() throws IOException;
}
