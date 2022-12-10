package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserMapper userMapper;

    public void createUser(User user) {
        userMapper.createUser(user);
    }

    @Transactional(readOnly = true)
    public User getUserByUsername(String username) {
        return userMapper.getUserByUsername(username);
    }


    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    public void deleteUserByUsername(String username) {
        userMapper.deleteUserByUsername(username);
    }


    public void isValidUsername(String username) {
        Optional.ofNullable(userMapper.getUserByUsername(username))
                .ifPresent(user -> {
                    throw new IllegalArgumentException("이미 존재하는 사용자입니다.");
                });
    }
}
