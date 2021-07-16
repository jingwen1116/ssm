package com.huang.pojo;

import java.util.Date;

public class Teacher {
    private Integer tId ;
    private String tCode;
    private String tName;
    private Integer User_type;
    private String password;
    private String phone;
    private Date time;
    private String other;

    public Teacher(Integer tId, String tCode, String tName, Integer user_type, String password, String phone, Date time, String other) {
        this.tId = tId;
        this.tCode = tCode;
        this.tName = tName;
        User_type = user_type;
        this.password = password;
        this.phone = phone;
        this.time = time;
        this.other = other;
    }

    public Teacher() {
    }

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public String gettCode() {
        return tCode;
    }

    public void settCode(String tCode) {
        this.tCode = tCode;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public Integer getUser_type() {
        return User_type;
    }

    public void setUser_type(Integer user_type) {
        User_type = user_type;
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

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}
