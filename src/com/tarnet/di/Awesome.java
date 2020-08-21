package com.tarnet.di;

import lombok.Data;

@Data
public class Awesome {
//    @Dependent
    private ILogger logger;

//    @Dependent
    public Awesome(ILogger logger) {
        this.logger = logger;
    }

    public void DoSomething(){
        System.out.println("Awesomethings done!");
        logger.log("Awesome->DoSomething");
    }
}
