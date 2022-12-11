package com.example.demo.entity;

import java.time.LocalDate;

import lombok.*;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Record {

	private Integer id;
	private Integer userId;
	
	private Voice voice;
	private Bgm bgm;
	private int duration;
	
	private String url;
	private LocalDate registerDatetime;
	
}
