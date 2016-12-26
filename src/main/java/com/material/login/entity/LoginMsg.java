package com.material.login.entity;

/**
 * Created by Doing on 2016/12/22 0022.
 */
public class LoginMsg {

    private long accountId;
    private String userName;
    private String password;
    private String userType;

    public LoginMsg() {
    }

    public LoginMsg(long accountId, String userName, String password, String userType) {
        this.accountId = accountId;
        this.userName = userName;
        this.password = password;
        this.userType = userType;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "LoginMsg{" +
                "accountId=" + accountId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", userType='" + userType + '\'' +
                '}';
    }
}
