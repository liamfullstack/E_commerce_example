package org.example.e_commerce.service.impl;

import org.example.e_commerce.model.User;
import org.example.e_commerce.dao.UserDao;
import org.example.e_commerce.dto.UserRegisterRequest;
import org.example.e_commerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        return userDao.createUser(userRegisterRequest);
    }


}
