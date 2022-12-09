package com.example.demo.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@JsonDeserialize
@JsonSerialize
@AllArgsConstructor
public class Record {

	@NonNull private int id;
	@NonNull private int userId;
	
	private int voiceId;
	private int bgmId;
	
	@NonNull private String url;
	@NonNull private LocalDate registerDatetime;
	
	public Record(int id, int userId, String url, LocalDate registerDatetime)
	{
		this.id = id;
		this.userId = userId;
		this.url = url;
		this.registerDatetime = registerDatetime;
	}
	
	
	
}
