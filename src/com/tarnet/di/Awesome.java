package com.tarnet.di;

import com.tarnet.annotation.Dependent;
import lombok.Data;

@Data
public class Awesome {
    @Dependent(klazz=ELKLogger.class)
    private ILogger logger;

    public Awesome(ILogger logger) {
        this.logger = logger;
    }

    public void DoSomething(){
        System.out.println("Awesomethings done!");
        logger.log("Awesome->DoSomething");
    }
}
