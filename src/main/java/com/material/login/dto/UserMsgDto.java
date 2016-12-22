package com.material.login.dto;

/**
 * Created by Doing on 2016/12/22 0022.
 */
public class UserMsgDto {
    private long accountId;
    private String password;
    private String userType;

    public UserMsgDto() {
    }

    public UserMsgDto(long accountId, String password, String userType) {
        this.accountId = accountId;
        this.password = password;
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

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
