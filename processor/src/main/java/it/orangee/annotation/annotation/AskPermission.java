package it.orangee.annotation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by luca on 14/09/16.
 */


/*
 *
 * Work in progress not use annotation for this library version.
 *
 * */


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AskPermission {

    String permission();

    int key() default 200;

}
