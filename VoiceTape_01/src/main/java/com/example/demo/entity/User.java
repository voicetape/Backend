package com.example.demo.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

	private int id; // (1). public �쑝濡� �븯�뒗 寃껋씠 留욌뒗吏� �옒 紐⑤Ⅴ寃좎쓬

	@NonNull private String username;
	@NonNull private String nickname;
	@NonNull private Role role;
	private LocalDate registerDatetime;
	private LocalDate modifyDatetime;
	private String emailAddress; // (2). email_address 異붽�

	// �깮�꽦�옄 留ㅺ컻蹂��닔 �뼱�뼸寃� �쟾�떖�븷吏� 怨좊�쇳빐蹂닿린 --> �씪�떒 ��異� ��留� 吏쒓린

}
