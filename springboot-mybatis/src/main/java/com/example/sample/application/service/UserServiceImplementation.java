package com.example.sample.application.service;

import com.example.sample.adapter.out.persistence.UserRepository;
import com.example.sample.application.port.UserService;
import com.example.sample.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImplementation implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<User> getUsers() {

        return userRepository.getUserList();
    }
}
