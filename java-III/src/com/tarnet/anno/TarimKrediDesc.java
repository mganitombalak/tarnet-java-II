package com.tarnet.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//@Retention(RetentionPolicy.SOURCE)// NOT COMPILED
//@Retention(RetentionPolicy.CLASS) // WRITTEN CLASS METADATA / JVM CANNOT ACCESS
@Retention(RetentionPolicy.RUNTIME) // HERTURLU ERISILIR.
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface TarimKrediDesc {
    public String value() default "";
}
