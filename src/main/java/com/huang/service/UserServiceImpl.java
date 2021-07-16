package com.huang.service;

import com.huang.dao.UserMapper;
import com.huang.pojo.Student;
import com.huang.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public class UserServiceImpl implements UserService {
//    @Autowired
    private UserMapper userMapper;

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
//业务代码
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

//    删除用户
    public int deleteUser(Integer id) {
        return userMapper.deleteUser(id);
    }

//    更新用户
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }
//获得总人数哦
    public List<User> queryAllUser(String userName,Integer userType,int from,int _pageSize) {
        System.out.println(userName+","+userType+","+from+","+_pageSize);
        return userMapper.queryAllUser(userName,userType,from,_pageSize);
    }
//通过id查询
    public User queryUserById(Integer id) {
        return userMapper.queryUserById(id);
    }

//    验证登录
    public User checkLogin(String userCode, String password) {
        return userMapper.checkLogin(userCode,password);
    }

//    是否存在该账号
    public int checkUserCode(String userCode) {
        return userMapper.checkUserCode(userCode);
    }
    //    查询总人数
    public int getUserCount(String queryUserName, Integer userType) {
        return userMapper.getUserCount(queryUserName,userType);
    }

    public List<User> queryAllType(Integer userType) {
        return userMapper.queryAllType(userType);
    }

}
