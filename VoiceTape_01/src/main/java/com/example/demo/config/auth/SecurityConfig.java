package com.example.demo.config.auth;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	private final CustomOAuth2UserService customOAuth2UserService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		System.out.println("SECURITY CONFIGÀÎ°Ç°¡ÀÌ·¯¹Ì;¾î");
		http.authorizeRequests().antMatchers("/login_sample").permitAll().antMatchers("/","/oauth","/css/**","/images/**","/js/**").permitAll()
		.antMatchers("/api/v1/**").hasRole("USER").anyRequest().authenticated().
		and().logout().logoutSuccessUrl("/login_sample").
		and().oauth2Login().defaultSuccessUrl("/login_sample").
		and().oauth2Login().userInfoEndpoint().userService(customOAuth2UserService);
		
		http.csrf().disable();
		http.csrf().disable().headers().frameOptions().disable();
	}
	

}