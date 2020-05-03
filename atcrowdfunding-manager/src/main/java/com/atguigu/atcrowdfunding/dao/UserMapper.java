package com.atguigu.atcrowdfunding.dao;

import com.atguigu.atcrowdfunding.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    public User getUserByAccountUserpassword(User user);
}
