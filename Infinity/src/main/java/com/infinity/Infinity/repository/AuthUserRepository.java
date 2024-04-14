package com.infinity.Infinity.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.infinity.Infinity.model.AuthUser;

public interface AuthUserRepository extends MongoRepository<AuthUser,String>{
	Optional<AuthUser> findByUsername(String username);
}
