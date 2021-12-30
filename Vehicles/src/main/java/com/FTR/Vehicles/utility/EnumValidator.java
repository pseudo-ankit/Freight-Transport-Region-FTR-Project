package com.FTR.Vehicles.utility;

import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EnumValidatorImpl.class)
public @interface EnumValidator {
    
    Class<? extends Enum<?>> enumClass();
    String message() default "must be any of enum {enumClass}";
    
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
