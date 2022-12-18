package com.example.demo.config.auth;

import java.time.LocalDate;
import java.util.Collections;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Config.OAuthAttributes;
import com.example.demo.dto.Config.SessionUser;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CustomOauth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {
	
	@Autowired
	private final UserMapper userMapper;
	
	private final HttpSession httpSession;
	
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		// TODO Auto-generated method stub
		OAuth2UserService<OAuth2UserRequest, OAuth2User> delegate = new DefaultOAuth2UserService();
		OAuth2User oAuth2User = delegate.loadUser(userRequest);
		
		String registrationId = userRequest.getClientRegistration().getRegistrationId();
		String userNameAttributeName = userRequest.getClientRegistration().getProviderDetails().getUserInfoEndpoint().getUserNameAttributeName();
		
		System.out.println("UERREQUEST  "+registrationId+"   "+userNameAttributeName+"   "+oAuth2User.getAttributes());
		System.out.println("TOKEN        "+userRequest.getAccessToken().getTokenValue());
		
		OAuthAttributes attributes = OAuthAttributes.ofKakao(userNameAttributeName, oAuth2User.getAttributes());
		
		User user = saveOrUpdate(attributes);
		System.out.println("ATTRIBUTES :: "+attributes);
		httpSession.setAttribute("user", new SessionUser(user));
		return new DefaultOAuth2User(Collections.singleton(new SimpleGrantedAuthority(Integer.toString(user.getId()))), attributes.getAttributes(), attributes.getNameAttributeKey());
	}
	
	private User saveOrUpdate(OAuthAttributes attributes) {
		System.out.println("222222222222222222222222");
		User us = new User(1810011, attributes.getName(), attributes.getNameAttributeKey(), Role.USER, LocalDate.now(), LocalDate.now(),attributes.getEmail());
		return us;
	}
}
