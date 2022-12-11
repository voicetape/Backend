package com.example.demo.service;

import com.example.demo.dto.ErrorCode;
import com.example.demo.entity.User;
import com.example.demo.exception.ApiException;
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
        validateDuplicateUser(user.getUsername());
        userMapper.createUser(user);
    }

    @Transactional(readOnly = true)
    public User getUserByUsername(String username) {
        return Optional.ofNullable(userMapper.getUserByUsername(username))
                .orElseThrow(() -> new ApiException(ErrorCode.USER_NOT_FOUND));
    }


    public void updateUser(User user) {
        Optional.ofNullable(getUserByUsername(user.getUsername()))
                .orElseThrow(() -> new ApiException(ErrorCode.USER_NOT_FOUND));
        userMapper.updateUser(user);
    }

    public void deleteUserByUsername(String username) {
        validateUserExists(username);
        userMapper.deleteUserByUsername(username);
    }


    public void validateDuplicateUser(String username) {

        Optional.ofNullable(userMapper.getUserByUsername(username))
                .ifPresent(user -> {
                    throw new ApiException(ErrorCode.USER_CONFLICT);
                });
    }

    public void validateUserExists(String username) {
        Optional.ofNullable(userMapper.getUserByUsername(username))
                .orElseThrow(() -> new ApiException(ErrorCode.USER_NOT_FOUND));
    }

}
