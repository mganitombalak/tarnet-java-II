package com.tarnet.di;


import com.tarnet.annotation.Dependee;

@Dependee(isDefault=true)
public class TextLogger implements ILogger {
    @Override
    public void log(String msg) {
        System.out.println("TextLogger:"+msg);
    }
}
