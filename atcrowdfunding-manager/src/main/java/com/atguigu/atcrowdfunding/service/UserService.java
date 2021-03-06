package com.atguigu.atcrowdfunding.service;

import com.atguigu.atcrowdfunding.entity.Role;
import com.atguigu.atcrowdfunding.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    public User getUserByAccountUserpassword(User user);

    public List<User> pageQueryData(Map<String,Object> map);

    public int pageQueryCount(Map<String,Object> map);

    public void insertUser(User user);

    public void updateUser(User user);

    public int deleteUser(Integer id);

    public int deleteUsers(Integer[] ids);

    public List<Role> selectRoles(Integer id);

    public void assignRole(Map<String,Integer> map);

    public void unAssignRole(Map<String,Integer> map);
}
