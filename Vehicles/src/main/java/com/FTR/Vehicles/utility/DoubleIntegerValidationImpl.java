package com.FTR.Vehicles.utility;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class DoubleIntegerValidationImpl implements ConstraintValidator<DoubleIntegerValidation, Double> {

    private Double number;

    @Override
    public void initialize(DoubleIntegerValidation constraintAnnotation) {
        // TODO Auto-generated method stub
    }
    
    @Override
    public boolean isValid(Double value, ConstraintValidatorContext context) {
        if(value!=null){
            number = ((Integer)value.intValue()).doubleValue();
            System.out.println("value: "+value+" number: "+number);
            return number>=0 && number.equals(value);
        }
        return true;
    }
    
}
