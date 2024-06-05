package org.bit.service;

import org.bit.mapper.UserMapper;
import org.bit.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User findByEmail(String email) {
        return userMapper.findByEmail(email);
    }

    public void insertUser(User user) {
        userMapper.insertUser(user);
    }
}

