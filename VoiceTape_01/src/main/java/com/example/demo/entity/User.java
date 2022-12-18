package com.example.demo.entity;

import java.util.Date;

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
	private Date registerDatetime;
	private Date modifyDatetime;

}
