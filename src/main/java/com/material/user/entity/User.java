package com.material.user.entity;

/**
 * Created by Doing on 2016/12/16 0016.
 */
public class User {
    private long accountId;
    private String password;
    private String userName;
    private String userType;

    public User(){

    }

    public User(long accountId, String password, String userName, String userType) {
        this.accountId = accountId;
        this.password = password;
        this.userName = userName;
        this.userType = userType;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "User{" +
                "accountId=" + accountId +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", userType='" + userType + '\'' +
                '}';
    }
}
