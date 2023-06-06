package com.example.customvalidation.customvalidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;

@Constraint(validatedBy = NotNullIfAnotherFieldHasValueValidator.class)
@Documented
@Target({TYPE, ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotNullIfAnotherFieldHasValue {
    String fieldName();
    String expectedFieldValue();
    String denpendFieldName();

    String message() default "can not null";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
