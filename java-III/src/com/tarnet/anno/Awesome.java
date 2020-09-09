package com.tarnet.anno;

public class Awesome {


    private String ImportantField;
    private int VeryImportantField;

    @TarimKrediDesc("awesome.get")
    public String getImportantField() {
        return ImportantField;
    }

    @TarimKrediDesc("awesome.set")
    public void setImportantField(String importantField) {
        ImportantField = importantField;
    }

    public int getVeryImportantField() {
        return VeryImportantField;
    }

    public void setVeryImportantField(int veryImportantField) {
        VeryImportantField = veryImportantField;
    }

    @ConditionalInvoke(order = 1)
    public void f1(){

    }

    @ConditionalInvoke(order = 2)
    public void f2(){

    }
    @ConditionalInvoke(value = true)
    public void f3(){

    }
}
