package com.example.sample.adapter.out.persistence;

import com.example.sample.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository {
    List<User> getUserList();
}
