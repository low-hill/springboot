package com.example.demo.controller;

import com.example.demo.dto.User;
import com.example.demo.dto.UserConditionQuery;
import com.example.demo.exception.UserNotExistException;
import com.fasterxml.jackson.annotation.JsonView;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping
    @JsonView(User.UserSimpleView.class)
    public List<User> query(UserConditionQuery condition){
        System.out.println(ReflectionToStringBuilder.toString(condition, ToStringStyle.MULTI_LINE_STYLE));
        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;
    }
    
    @GetMapping("/{id:\\d+}")
    @JsonView(User.UserDetailView.class)
    public User getInfo(@PathVariable String id){
        if("1".equals(id)){
            User user = new User();
            user.setUsername("tom");
            return user;
        }else{
            throw new UserNotExistException(id);
        }
    }

    @PostMapping
    public User create(@RequestBody @Valid User user, BindingResult errors){
        if(errors.hasErrors()){
            errors.getAllErrors().stream().forEach(error -> System.out.println(error.getDefaultMessage()));
        }
        user.setId("1");
        return user;
    }

    @PutMapping("/{id:\\d+}")
    public User update(@RequestBody @Valid User user, BindingResult errors){
        if(errors.hasErrors()){
            errors.getAllErrors().stream().forEach(error -> System.out.println(error.getDefaultMessage()));
        }
        return user;
    }

    @DeleteMapping("/{id:\\d+}")
    public void delete(@PathVariable String id){
        System.out.println(id);
    }
}
