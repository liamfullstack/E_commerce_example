package org.example.e_commerce.dao;

import org.example.e_commerce.model.User;
import org.example.e_commerce.dto.UserRegisterRequest;

public interface UserDao {
    Integer createUser(UserRegisterRequest userRegisterRequest);

    User getUserById(Integer userId);
}
