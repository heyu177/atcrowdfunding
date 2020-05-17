package com.atguigu.atcrowdfunding.service.impl;

import com.atguigu.atcrowdfunding.dao.UserMapper;
import com.atguigu.atcrowdfunding.entity.Role;
import com.atguigu.atcrowdfunding.entity.User;
import com.atguigu.atcrowdfunding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public User getUserByAccountUserpassword(User user) {
        return userMapper.getUserByAccountUserpassword(user);
    }

    public List<User> pageQueryData(Map<String, Object> map) {
        return userMapper.pageQueryData(map);
    }

    public int pageQueryCount(Map<String, Object> map) {
        return userMapper.pageQueryCount(map);
    }

    public void insertUser(User user) {
        userMapper.insertUser(user);
    }

    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    public int deleteUser(Integer id) {
        return userMapper.deleteUser(id);
    }

    public int deleteUsers(Integer[] ids) {
        return userMapper.deleteUsers(ids);
    }

    public List<Role> selectRoles(Integer id) {
        return userMapper.selectRoles(id);
    }

    public void assignRole(Map<String, Integer> map) {
        userMapper.assignRole(map);
    }

    public void unAssignRole(Map<String, Integer> map) {
        userMapper.unAssignRole(map);
    }
}
