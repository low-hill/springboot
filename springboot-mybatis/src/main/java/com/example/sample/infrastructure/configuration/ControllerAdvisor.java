package com.example.sample.infrastructure.configuration;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = {"com.example.sample"})
public class ControllerAdvisor {
    @InitBinder
    public void directFiendAcess(WebDataBinder binder){
        binder.initDirectFieldAccess();
    }
}
