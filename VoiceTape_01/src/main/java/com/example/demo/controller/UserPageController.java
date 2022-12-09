package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class UserPageController {
	@RequestMapping("/java")
	public static void main(String[] args) {
		System.out.println("helloWorld!");
	}
	
	@RequestMapping("/voicetape")
	public String voiceTapePage() {
		return "{ VoiceTape } Start"; 
	}

}
