package com.atguigu.atcrowdfunding.dao;

import com.atguigu.atcrowdfunding.entity.Role;
import com.atguigu.atcrowdfunding.entity.User;
import org.apache.ibatis.annotations.Param;
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

    public int deleteUsers(@Param("ids") Integer[] ids);

    public List<Role> selectRoles(Integer id);

    public void assignRole(Map<String,Integer> map);

    public void unAssignRole(Map<String,Integer> map);
}
