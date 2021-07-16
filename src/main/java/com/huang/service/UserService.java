package com.huang.service;

import com.huang.dao.UserMapper;
import com.huang.pojo.Student;
import com.huang.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {

    //    增
    int addUser(User user);
    //    删
    int deleteUser(Integer id);
    //    改
    int updateUser(User user);

    //    查
    List<User> queryAllUser(String userName,Integer userType,int from,int _pageSize);

    User queryUserById(Integer id);

    //    登录实现
    User checkLogin(String userCode, String password);

    //    验证账号实现
    int checkUserCode(String userCode);

    //    查询总人数
    int getUserCount(String queryUserName, Integer userType);

    //    查询全部类型
    List<User> queryAllType(@Param("userType") Integer userType);
}
