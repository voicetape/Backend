package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.User;

@Mapper
public interface UserMapper {
	
	void createUser(User user);

	User getUserByUsername(String username);

	void updateUser(User user);

	void deleteUserByUsername(String username);
}
