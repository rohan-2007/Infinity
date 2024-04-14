package com.infinity.Infinity.config;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.security.auth.message.config.AuthConfig;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

//	@Bean
//	public UserDetailsService userDetailsService()
//	{
//		System.out.println("UUUUUUUU");
//		Collection<UserDetails> users = new ArrayList<>();
//		UserDetails user1 = User.withDefaultPasswordEncoder().username("aaaa").password("aaaa").roles("user").build();
//		System.out.println("aaaa " + user1.getPassword());
//
//		UserDetails user2 = User.withDefaultPasswordEncoder().username("bbbb").password("bbbb").roles("user").build();
//		users.add(user1);
//		users.add(user2);
//		return new InMemoryUserDetailsManager(users);
//	}
	
	@Bean
	public PasswordEncoder passwordEncoder() 
	{
		return new BCryptPasswordEncoder();
	}
	
	@Bean //"/addUser","/error"
	public SecurityFilterChain defaultFilterChain(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity
				.csrf(csrf->csrf.disable())
				.authorizeHttpRequests(auth-> auth.requestMatchers("/","/css/**","/images/**","/log","/error").permitAll()
				.anyRequest()
				.authenticated())
//				.httpBasic(c -> c.authenticationEntryPoint(
//				         (request, response, authException) -> response.sendError(HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.getReasonPhrase())))
				//.httpBasic(Customizer.withDefaults())
				.formLogin(Customizer.withDefaults())
				.build();
	}
}
