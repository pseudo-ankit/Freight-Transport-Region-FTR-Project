package com.FTR.Vehicles.utility;

import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DoubleIntegerValidationImpl.class)
public @interface DoubleIntegerValidation {
    
    String message() default "vahicle maxLiftingCapacity invalid value";
    
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
