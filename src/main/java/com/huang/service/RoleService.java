package com.huang.service;

import com.huang.pojo.Role;

import java.util.List;

public interface RoleService {
    //    获得角色列表
    List<Role> queryAllRole();

    //    根据类型查询用户
    List<Role> queryRoleByType(Integer userType);
}
