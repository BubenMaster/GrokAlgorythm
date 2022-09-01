package com.yoj.grok.tools.sorter;

import com.yoj.grok.tools.sorter.sort_methods.SortMethod;

public class Sort {
    private final String[] words;

    private Sort(String[] words) {
        this.words = words;
    }

    public static Sort of(String[] wordsArray){
        return new Sort(wordsArray);
    }

    public String[] byMethod(SortMethod method){
        return method.sortWithMeasure(this.words);
    }

}
