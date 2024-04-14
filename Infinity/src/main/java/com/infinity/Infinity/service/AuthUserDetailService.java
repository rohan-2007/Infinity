package com.infinity.Infinity.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.infinity.Infinity.model.AuthUser;
import com.infinity.Infinity.repository.AuthUserRepository;

@Service
public class AuthUserDetailService implements UserDetailsService {
	
	@Autowired
	AuthUserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<AuthUser> authUser = userRepo.findByUsername(username.toLowerCase());
		if (!authUser.isPresent()) {
			throw new UsernameNotFoundException(username);
		}
		return User.builder()
				.username(authUser.get().getUsername())
				.password(authUser.get().getPassword())
				.build();
	}
	
	

}
