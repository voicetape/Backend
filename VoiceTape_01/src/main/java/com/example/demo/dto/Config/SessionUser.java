package com.example.demo.dto.Config;

import com.example.demo.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
@AllArgsConstructor
public class SessionUser {
	
	private String name; 
	private String email;

}
