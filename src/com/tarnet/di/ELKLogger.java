package com.tarnet.di;

//@Component  / @Service / @Repository / @Bean / @Controller
public class ELKLogger implements ILogger {
    @Override
    public void log(String msg) {
        System.out.println("ELKLogger:"+msg);
    }
}
