package com.yoj.grok.tools.text_extractor;

import java.io.IOException;
import java.util.Set;

public interface ExtractorFromFile {
    long getMethodExecutionTime();
    void setMethodExecutionTime(long timeRecord);


    StringBuilder extractClearedRawTextAsBuilder() throws IOException;
    Set<String> extractAsSet(Set<String> setWithDesiredType) throws IOException;
    String[] extractAsArrayOfUniques(Set<String> setWithDesiredType) throws IOException;
}
