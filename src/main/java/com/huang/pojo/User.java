package com.huang.pojo;

import java.util.Date;

public class User {
    private Integer id ;
    private String userCode;
    private String userName;
    private Integer userType;
    private String password;
    private String phone;
    private Date time;
    private String post;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userCode='" + userCode + '\'' +
                ", userName='" + userName + '\'' +
                ", userType=" + userType +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", time=" + time +
                ", post='" + post + '\'' +
                ", RoleName='" + RoleName + '\'' +
                '}';
    }

    //   外键
    private String RoleName;

    public User() {
    }

    public User(Integer id, String userCode, String userName, Integer userType, String password, String phone, Date time, String post, String roleName) {
        this.id = id;
        this.userCode = userCode;
        this.userName = userName;
        this.userType = userType;
        this.password = password;
        this.phone = phone;
        this.time = time;
        this.post = post;
        RoleName = roleName;
    }


    public String getRoleName() {
        return RoleName;
    }

    public void setRoleName(String roleName) {
        RoleName = roleName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }
}
