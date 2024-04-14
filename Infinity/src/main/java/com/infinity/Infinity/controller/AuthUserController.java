package com.infinity.Infinity.controller;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infinity.Infinity.model.AuthUser;
import com.infinity.Infinity.repository.AuthUserRepository;

//import lombok.AllArgsConstructor;

@Controller
//@AllArgsConstructor
public class AuthUserController {
	  
	@Autowired
	AuthUserRepository userRepo;
	
	@Autowired
	PasswordEncoder pwdEncoder;
	
	@PostMapping("/addUser")
	public String userSignup(@ModelAttribute AuthUser user)
	{
		System.out.println("dddddddddd");
		System.out.println(user.toString());
//		userRepo.save(user);
//		return "signup";
		
		try {
			if (userRepo.findByUsername(user.getUsername()).isPresent()) {
				System.out.println("Username taken");
//				return ResponseEntity.status(HttpStatus.CONFLICT).body("Username already taken");
			}
			user.setPassword(pwdEncoder.encode(user.getPassword()));
			AuthUser save = userRepo.save(user);
			System.out.println("created");
			return "signup";
//			return ResponseEntity.ok(HttpStatus.CREATED);
		} catch (Exception e) {
//			return ResponseEntity.internalServerError().body(e.getMessage());
			return "error";
		}
	}
}
