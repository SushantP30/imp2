package com.shop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.entity.User;

public interface userRepository extends JpaRepository<User, Long> {

	Optional<User> findByUserName(String userName);
	 Optional<User> findByEmail(String email); 

}
