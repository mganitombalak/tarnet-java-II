package com.tarnet.anno;

import java.util.function.Supplier;

public class ConditionalInterface<T,R extends T,P extends T > {

    T invoke(boolean cond, Supplier<R> r, Supplier<P> p){

        return (cond? r:p).get() ;
    }

}
