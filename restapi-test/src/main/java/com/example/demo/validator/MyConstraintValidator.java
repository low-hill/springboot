package com.example.demo.validator;

import com.example.demo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MyConstraintValidator implements ConstraintValidator<MyConstraint, Object> {

    @Autowired
    private HelloService helloService;

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        System.out.println(value);
        helloService.greeting("tom");
        return true;
    }
}
