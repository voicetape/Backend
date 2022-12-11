package com.example.demo.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.*;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Record {

	@NonNull private int id;
	@NonNull private int userId;
	
	private Voice voice;
	private Bgm bgm;
	private int duration;
	
	@NonNull private String url;
	@NonNull private LocalDate registerDatetime;
	
}
