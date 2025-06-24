package com.shop.service;

import com.shop.dto.userLoginDTO;
import com.shop.dto.userRegistrationDTO;
import com.shop.entity.User;

public interface UserService {

    public User registerUser(userRegistrationDTO dto);
    public User loginUser(userLoginDTO dto);
    public User getUserById(Long userId);
}
