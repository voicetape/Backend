package com.example.demo.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.example.demo.mapper.UserMapper;
import com.example.demo.dto.Config.KakaoProfile;
import com.example.demo.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class KakaoService {
	
	@Autowired
	private UserMapper userDAO;
	
	// AccessToken�� ���� ����� ���� �޾ƿ���
	public void getUserInfo( String access_Token ) {
		
		// AccessToken ���
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer "+access_Token);
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		 
		HttpEntity<MultiValueMap<String, String>> kakaoInfoRequest = new HttpEntity<>(headers);
		
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<String> response = restTemplate.exchange("https://kapi.kakao.com/v2/user/me", HttpMethod.POST, kakaoInfoRequest, String.class);
		
		System.out.println("Response body :: "+response.getBody());
		
		ObjectMapper objectMapper = new ObjectMapper();
		KakaoProfile profile = null;
		
		try {
			profile = objectMapper.readValue(response.getBody(), KakaoProfile.class);
		}catch(JsonProcessingException e)
		{
			e.printStackTrace();
		}
		
		// ������ ���鋚 ���� �̷��� �Ű����� ������ �´���
		
		// role_id �� �߱޹ް� ���⼭ �Ҵ����־ USERDTO �� �����ϴ� �� �����ؾ���
		
		//UserDTO userDTO2 = new UserDTO(profile.id, username, nickname, email_address, role_id, reg_dttm, mod_dttm)
		
		LocalDate dateAndtime = LocalDate.now();
		
		User user = new User(profile.id, "shpark0308", profile.properties.getNickname(), profile.kakaoAccount.getEmail(), 12345, dateAndtime, dateAndtime);
		userDAO.insert(user);
	}
}
