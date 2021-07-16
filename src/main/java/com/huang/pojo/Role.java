package com.huang.pojo;

public class Role {
    private Integer id ;
    private Integer userType;
    private String roleName;

    public Role(Integer id, Integer userType, String roleName) {
        this.id = id;
        this.userType = userType;
        this.roleName = roleName;
    }

    public Role() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", userType=" + userType +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
