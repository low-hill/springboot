package com.example.demo.dto;

import com.example.demo.validator.MyConstraint;
import com.fasterxml.jackson.annotation.JsonView;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.util.Date;

public class User {

    public interface UserSimpleView {};
    public interface UserDetailView extends UserSimpleView{};
    private String id;
    @MyConstraint(message="test for constraint")
    private String username;
    @NotBlank(message="password must not be blank")
    private String password;
    @Past(message="birthday must be a past date")
    private Date birthday;

    @JsonView(UserSimpleView.class)
    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    @JsonView(UserSimpleView.class)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @JsonView(UserDetailView.class)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @JsonView(UserSimpleView.class)
    public Date getBirthday() { return birthday; }

    public void setBirthday(Date birthday) { this.birthday = birthday; }
}
