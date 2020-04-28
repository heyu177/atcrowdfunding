package com.atguigu.atcrowdfunding.dao;

import com.atguigu.atcrowdfunding.entity.User;

public interface UserMapper {

    public User getUserByAccountUserpassword(User user);
}
