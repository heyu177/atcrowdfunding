package com.atguigu.atcrowdfunding.service.impl;

import com.atguigu.atcrowdfunding.dao.UserMapper;
import com.atguigu.atcrowdfunding.entity.User;
import com.atguigu.atcrowdfunding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public User getUserByAccountUserpassword(User user) {
        return userMapper.getUserByAccountUserpassword(user);
    }
}
