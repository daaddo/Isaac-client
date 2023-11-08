package org.example.isaac;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE, ElementType.PARAMETER, ElementType.CONSTRUCTOR, ElementType.FIELD})

public @interface TODO {
    String todo() default "";
}
