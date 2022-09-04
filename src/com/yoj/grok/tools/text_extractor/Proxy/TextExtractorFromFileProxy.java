package com.yoj.grok.tools.text_extractor.Proxy;

import com.yoj.grok.tools.text_extractor.ExtractorFromFile;
import com.yoj.grok.tools.text_extractor.WordsExtractorFromFile;

import java.lang.reflect.Proxy;

public class TextExtractorFromFileProxy {



    public static ExtractorFromFile getProxy(String fileDir) {
        WordsExtractorFromFile origin = new WordsExtractorFromFile(fileDir);

        ClassLoader loader = WordsExtractorFromFile.class.getClassLoader();
        Class[] interfaces = new Class[]{ExtractorFromFile.class};
        CustomInvocationHandler invocationHandler = new CustomInvocationHandler(origin);

        return (ExtractorFromFile) Proxy.newProxyInstance(loader, interfaces, invocationHandler);
    }
}
