package com.tarnet.di;

public class Awesome {

    // @Autowired
    // @Qualifer("ELKLogger")
    private ILogger logger;

    public Awesome(ILogger logger) {
        this.logger = logger;
    }

    public void DoSomething(){
        System.out.println("Awesomethings done!");
        logger.log("Awesome->DoSomething");
    }
}
