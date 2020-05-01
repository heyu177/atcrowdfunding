package com.atguigu.atcrowdfunding.dao;

import com.atguigu.atcrowdfunding.entity.User;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserMapper {

    public User getUserByAccountUserpassword(User user);
}
