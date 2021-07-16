package com.huang.dao;

import com.huang.pojo.Student;
import com.huang.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//@Mapper
public interface UserMapper {

//    增
    int addUser(User user);
//    删
    int deleteUser(Integer id);
//    改
    int updateUser(User user);

//    查

    List<User> queryAllUser(@Param("userName") String userName,@Param("userType")Integer userType,@Param("from")int from, @Param("pageSize")int pageSize);

    User queryUserById(Integer id);

//    登录实现
    User checkLogin(@Param("userCode") String userCode,@Param("password")  String password);


    //    验证账号实现
    int checkUserCode(@Param("userCode") String userCode);

    //    得出多少条记录
    int getUserCount(@Param("userName") String queryUserName, @Param("userType")Integer userType);

//    查询全部类型
    List<User> queryAllType(@Param("userType") Integer userType);
}
