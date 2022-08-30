package com.yoj.grok.tools.text_extractor.Proxy;

import com.yoj.grok.tools.text_extractor.ExtractorFromFile;
import com.yoj.grok.tools.text_extractor.TextExtractorFromFile;

import java.lang.reflect.Proxy;

public class TextExtractorFromFileProxy {



    public static ExtractorFromFile getProxy(String fileDir) {
        TextExtractorFromFile origin = new TextExtractorFromFile(fileDir);

        ClassLoader loader = TextExtractorFromFile.class.getClassLoader();
        Class[] interfaces = new Class[]{ExtractorFromFile.class};
        CustomInvocationHandler invocationHandler = new CustomInvocationHandler(origin);

        return (ExtractorFromFile) Proxy.newProxyInstance(loader, interfaces, invocationHandler);
    }
}
