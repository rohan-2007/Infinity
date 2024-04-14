package com.infinity.Infinity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infinity.Infinity.model.AuthUser;
import com.infinity.Infinity.repository.AuthUserRepository;

@Controller
public class IndexController {

	@Autowired
	AuthUserRepository userRepo;
	
	@GetMapping("/")
	public String index()
	{
		System.out.println("iiiiiiiiiiiii");
		return "index";
	}
	
	@GetMapping("/log")
	public String login()
	{
		System.out.println("WWWWWWWWWWWWWWWWW");
		return "login";
	}
	
	@GetMapping("/signup")
	public String signUp()
	{
		return "signup";
	}
	 
	@GetMapping("/users")
	public List<AuthUser> fetchUsers()
	{
		System.out.println("here");
		List<AuthUser> users = userRepo.findAll();
		System.out.println(users);
		return users;
	}
	
	@PostMapping("/userLogin")
	public String userLogin(@ModelAttribute AuthUser user)
	{
		System.out.println(user.toString());
		return "index";
	}
}
