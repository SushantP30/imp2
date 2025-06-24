package com.shop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dto.userLoginDTO;
import com.shop.dto.userRegistrationDTO;
import com.shop.entity.User;
import com.shop.repository.userRepository;

@Service
public class userServiceImpl implements UserService {

	@Autowired
	private userRepository userRepo;
	  @Override
	    public User registerUser(userRegistrationDTO dto) {

	        // Check if email already exists
	        Optional<User> existingUserByEmail = userRepo.findByEmail(dto.getEmail());
	        if (existingUserByEmail.isPresent()) {
	            throw new RuntimeException("Email already exists. Please use a different email.");
	        }

	        // Create user
	        User user = new User();
	        user.setUserName(dto.getUsername());
	        user.setPassword(dto.getPassword());
	        user.setEmail(dto.getEmail());

	        return userRepo.save(user);
	    }


	 public User loginUser(userLoginDTO dto) {
	        return userRepo.findByUserName(dto.getUsername())
	                .filter(user -> user.getPassword().equals(dto.getPassword()))
	                .orElseThrow(() -> new RuntimeException("Invalid username or password"));
	    }

	 public User getUserById(Long userId) {
		    return userRepo.findById(userId)
		            .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));
		}


}
