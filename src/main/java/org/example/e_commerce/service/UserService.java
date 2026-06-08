package org.example.e_commerce.service;

import org.example.e_commerce.model.User;
import org.example.e_commerce.dto.UserRegisterRequest;

public interface UserService {

    User getUserById(Integer userId);

    Integer register(UserRegisterRequest userRegisterRequest);
}
