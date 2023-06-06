package com.example.customvalidation.customvalidator;

import org.springframework.beans.BeanWrapperImpl;
import org.springframework.util.ObjectUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotNullIfAnotherFieldHasValueValidator implements ConstraintValidator<NotNullIfAnotherFieldHasValue, Object> {
    private String fieldName;
    private String dependFieldName;
    private String expectedFieldValue;

    @Override
    public void initialize(NotNullIfAnotherFieldHasValue constraintAnnotation) {
        fieldName = constraintAnnotation.fieldName();
        dependFieldName = constraintAnnotation.fieldName();
        expectedFieldValue = constraintAnnotation.expectedFieldValue();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {

        if(value == null) return true;

        Object fieldValue = new BeanWrapperImpl(value).getPropertyValue(fieldName);
        Object dependFieldValue = new BeanWrapperImpl(value).getPropertyValue(dependFieldName);

        if(expectedFieldValue.equals(dependFieldValue) && ObjectUtils.isEmpty(dependFieldValue)){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
                    .addPropertyNode(dependFieldName)
                    .addConstraintViolation();
            return false;
        }

        return true;
    }
}
