package com.material.login.dto;

/**
 * Created by Doing on 2016/12/24 0024.
 */
public class LoginMsgDto {
    private String userType;
    private String userName;

    public LoginMsgDto(String userType, String userName) {
        this.userType = userType;
        this.userName = userName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "LoginMsgDto{" +
                "userType='" + userType + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
