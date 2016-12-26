package com.material.login.service;

import com.material.login.dto.LoginMsgDto;
import com.material.login.dto.UserMsgDto;

/**
 * Created by Doing on 2016/12/17 0017.
 */
public interface ILoginService {

    /**
     *
     * @param accountId 用户登录账号
     * @param password 用户密码（加密）
     * @return  null：用户密码错误
     */
    LoginMsgDto checkPassword(long accountId, String password);

    boolean updatePassword(long accountId, String oldPassword, String newPassword);

    UserMsgDto getUserMsg(long accountId);
}
