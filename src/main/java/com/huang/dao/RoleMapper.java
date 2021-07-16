package com.huang.dao;

import com.huang.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
//    获得角色列表
    List<Role> queryAllRole();
//    根据类型查询用户
    List<Role> queryRoleByType(@Param("userType")Integer userType);

}
