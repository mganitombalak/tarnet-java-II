package com.tarnet.groupbyandpartitionby;

public enum Department {
    HumanResources("HR Deparment"),
    InformationTechnologies("IT Department"),
    Procurement("Procurement Deparment"),
    Marketing("Martketing Deparment");

    private String description;

    Department(String desc){
        this.description=desc;
    }
}
