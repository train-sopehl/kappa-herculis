package com.herculis.annotation;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Field {

    /**
     * <p>real value of field of API</p>
     *
     * @return alias of fields
     */
    String value() default "";

    /**
     * <p>Decide to ignore object fields</p>
     *
     * @return if ignored return true, if not return false
     */
    boolean ignored() default false;

}
