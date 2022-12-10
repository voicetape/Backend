package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

// hihi
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class VoiceTape01Application {

	public static void main(String[] args) {
		SpringApplication.run(VoiceTape01Application.class, args);
	}

}
