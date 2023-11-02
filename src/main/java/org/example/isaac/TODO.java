package org.example.isaac;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)

public @interface TODO {
    String todo() default "";
}
