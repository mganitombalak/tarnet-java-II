package com.tarnet.di;



@Dependee(isDefault=true)
public class TextLogger implements ILogger {
    @Override
    public void log(String msg) {
        System.out.println("TextLogger:"+msg);
    }
}
