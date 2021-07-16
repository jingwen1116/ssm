package com.huang.pojo;

public class SelectCourse {
    private Integer id;
    private Integer cid;
    private Integer sid;

    private String courseName;
    private String userName;
    private String userCode;

    @Override
    public String toString() {
        return "SelectCourse{" +
                "id=" + id +
                ", cid=" + cid +
                ", sid=" + sid +
                ", courseName='" + courseName + '\'' +
                ", userName='" + userName + '\'' +
                ", userCode='" + userCode + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }
}
