package com.tarnet.di;


//@Component  / @Service / @Repository / @Bean / @Controller
public class TextLogger implements ILogger {
    @Override
    public void log(String msg) {
        System.out.println("TextLogger:"+msg);
    }
}
