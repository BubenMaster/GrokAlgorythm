package com.yoj.grok.tools.text_extractor.Proxy;

import com.yoj.grok.tools.text_extractor.ExtractorFromFile;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Date;

public class CustomInvocationHandler implements InvocationHandler {

    ExtractorFromFile obj;
    public CustomInvocationHandler(ExtractorFromFile obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Date start = new Date();
        Object methodResult = method.invoke(obj,args);
        if (!method.getName().equals("getMethodExecutionTime")) {
            System.out.println(method.getName());
            obj.setMethodExecutionTime(new Date().getTime() - start.getTime());
        }
        return methodResult;
    }
}
