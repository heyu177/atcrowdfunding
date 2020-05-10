package com.atguigu.atcrowdfunding.dao;

import com.atguigu.atcrowdfunding.entity.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
public interface UserMapper {

    public User getUserByAccountUserpassword(User user);

    public List<User> pageQueryData(Map<String,Object> map);

    public int pageQueryCount(Map<String,Object> map);

    public void insertUser(User user);

    public void updateUser(User user);

    public int deleteUser(Integer id);

    public int deleteUsers(Integer[] ids);
}
