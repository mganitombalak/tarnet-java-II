package com.tarnet.di;


import com.tarnet.annotation.Dependee;

@Dependee
public class ELKLogger implements ILogger {

    @Override
    public void log(String msg) {
        System.out.println("ELKLogger:"+msg);
    }
}
