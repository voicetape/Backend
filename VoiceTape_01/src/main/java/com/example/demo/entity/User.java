package com.example.demo.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.*;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class User {

	private int id; // (1). public 으로 하는 것이 맞는지 잘 모르겠음

	@NonNull private String username;
	@NonNull private String nickname;
	@NonNull private Role role;
	private LocalDate registerDatetime;
	private LocalDate modifyDatetime;
	private String emailAddress; // (2). email_address 추가

	// 생성자 매개변수 어떻게 전달할지 고민해보기 --> 일단 대충 틀만 짜기

}
