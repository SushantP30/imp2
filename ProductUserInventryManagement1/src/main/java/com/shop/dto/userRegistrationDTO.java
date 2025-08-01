package com.shop.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class userRegistrationDTO {

	 @NotBlank(message = "Username is required")
	    @Size(min = 4, max = 20, message = "Username must be between 4 and 20 characters")
	    private String userName;

	    @NotBlank(message = "Password is required")
	    @Size(min = 6, message = "Password must be at least 6 characters long")
	    @Pattern(
	        regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d@$!%*?&]{6,}$",
	        message = "Password must contain at least one letter and one number"
	    )
	    private String password;

	    @NotBlank(message = "Email is required")
	    @Email(message = "Please enter a valid email address")
	    private String email;

		public String getUsername() {
			return userName;
		}

		public void setUsername(String username) {
			this.userName = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
	    
	    
}
