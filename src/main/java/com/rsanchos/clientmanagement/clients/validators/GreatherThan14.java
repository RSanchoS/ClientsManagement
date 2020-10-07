package com.rsanchos.clientmanagement.clients.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Constraint(validatedBy = GreatherThan14Validator.class)
public @interface GreatherThan14 {

    String message() default "{GreatherThan14.invalid}";
	Class<?>[] groups() default { };
	Class<? extends Payload>[] payload() default { };
}

