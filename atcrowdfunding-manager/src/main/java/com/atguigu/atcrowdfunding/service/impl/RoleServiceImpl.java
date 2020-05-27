package com.atguigu.atcrowdfunding.service.impl;

import com.atguigu.atcrowdfunding.dao.RoleMapper;
import com.atguigu.atcrowdfunding.entity.Role;
import com.atguigu.atcrowdfunding.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    public List<Role> pageQueryData(Map<String, Object> map) {
        return roleMapper.pageQueryData(map);
    }

    public int pageQueryCount(Map<String, Object> map) {
        return roleMapper.pageQueryCount(map);
    }
}
