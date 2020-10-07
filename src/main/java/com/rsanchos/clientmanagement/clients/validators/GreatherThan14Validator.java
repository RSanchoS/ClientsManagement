package com.rsanchos.clientmanagement.clients.validators;

import java.time.OffsetDateTime;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class GreatherThan14Validator implements ConstraintValidator<GreatherThan14, OffsetDateTime> {

    @Override
    public boolean isValid(OffsetDateTime value, ConstraintValidatorContext context) {
        return value.isBefore(OffsetDateTime.now().minusYears(14));
    }


    
}
