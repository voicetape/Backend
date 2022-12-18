package com.example.demo.dto.Config;

import java.time.LocalDate;
import java.util.Map;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;

import lombok.Builder;
import lombok.Data;

@Data
public class OAuthAttributes {
	private Map<String, Object> attributes;
	private String nameAttributeKey;
	private String name;
	private String email;
	
	@Builder
	public OAuthAttributes(Map<String, Object> attributes, String nameAttributeKey, String name, String email)
	{
		this.attributes = attributes;
		this.nameAttributeKey = nameAttributeKey;
		this.name = name;
		this.email = email;
	}
	
	public static OAuthAttributes ofKakao(String userNameAttributeName, Map<String, Object> attributes) {
		System.out.println("ATTRIBUTES :: "+attributes);
		/* 분리해서 저장해주는 것 뿐 */
		Map<String,Object> response = (Map<String, Object>)attributes.get("kakao_account");
		Map<String, Object> profile = (Map<String, Object>) response.get("profile");
		System.out.println("[1]. RESPONSE :: "+response);
		System.out.println("[2]. PROFILE :: "+profile);
		return OAuthAttributes.builder().name((String) profile.get("nickname")).email((String) response.get("email")).attributes(attributes).nameAttributeKey(userNameAttributeName).build();
	}
	
	public User toEntity() {
		return new User(1810011, name, email, Role.USER, LocalDate.now(), LocalDate.now(), email ); // 일단 임으로 하는 것
		
	}
}
