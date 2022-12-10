package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.User;

@Mapper
public interface UserMapper {
	
	void createUser(User user);

	User getUserByUsername(String username);

	void updateUserByUsername(String username);

	void deleteUserByUsername(String username);
}
