package com.example.sample.application.port;

import com.example.sample.domain.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
}
