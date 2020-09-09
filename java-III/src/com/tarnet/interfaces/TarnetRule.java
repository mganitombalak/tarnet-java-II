package com.tarnet.interfaces;

import java.util.function.UnaryOperator;

@FunctionalInterface
public interface TarnetRule<T extends IRule> extends UnaryOperator<T> {
    default void invoke(T p){p.Execute();}
}
