package com.tarnet.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // SOURCE COMPILE EDILMEZ  CLASS METADATA YAZILIR AMA JVM OKUMAZ RUNTIME HERTURLU ERISILIR
@Target(ElementType.METHOD) // Java 9 MODULE
public @interface TarimKredi {
}
