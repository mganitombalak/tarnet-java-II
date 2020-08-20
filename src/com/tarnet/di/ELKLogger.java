package com.tarnet.di;


@Dependee
public class ELKLogger implements ILogger {

    @Override
    public void log(String msg) {
        System.out.println("ELKLogger:"+msg);
    }
}
