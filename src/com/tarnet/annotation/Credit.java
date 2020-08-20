package com.tarnet.annotation;

import lombok.Data;

@Data
public class Credit {
    private String type;

    public Credit(String type) {
        this.type = type;
    }

    @TarimKredi
    public void useCredit() {
        System.out.println(this.type + " credit has been used.");
    }
}
