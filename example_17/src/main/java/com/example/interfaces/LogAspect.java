package com.example.interfaces;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
//@retention annotation is used to tell Spring that this annotation should be available at runtime so that Spring can use it to check if the method is annotated with this annotation or not
@Retention(RetentionPolicy.RUNTIME)
//@target annotation is used to tell Spring that this annotation can be used only on methods and not on classes or fields or packages
@Target(ElementType.METHOD)
public @interface LogAspect {
}
