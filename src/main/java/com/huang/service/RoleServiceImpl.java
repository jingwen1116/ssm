package com.huang.service;


import com.huang.dao.RoleMapper;
import com.huang.pojo.Role;

import java.util.List;

public class RoleServiceImpl implements RoleService {

    private RoleMapper roleMapper;
    public void setRoleMapper(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    public List<Role> queryAllRole() {
        return roleMapper.queryAllRole();
    }

    public List<Role> queryRoleByType(Integer userType) {
        return roleMapper.queryRoleByType(userType);
    }
}
