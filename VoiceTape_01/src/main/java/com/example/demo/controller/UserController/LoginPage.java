package com.example.demo.controller.UserController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class LoginPage {
	
	@RequestMapping("/java")
	public static void main(String[] args) {
		System.out.println("helloWorld!");
	}
	
	@RequestMapping("/voicetape")
	public String voiceTapePage() {
		return "{ VoiceTape } Start"; 
	}

}
