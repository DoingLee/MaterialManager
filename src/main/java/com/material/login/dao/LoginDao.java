package com.material.login.dao;

import com.material.login.entity.LoginMsg;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Doing on 2016/12/17 0017.
 */
public interface LoginDao {
    /**
     * 获取用户信息
     * @param accountId 用户登录名
     * @return 数据库中的用户加密密码、用户类型
     */
    LoginMsg getUserLoginMsg(long accountId);

    /**
     * 更新密码
     * @param accountId
     * @param newPassword 新密码
     * @return 1：更新成功
     */
    int updatePassword(@Param("accountId") long accountId,
                       @Param("oldPassword") String oldPassword,
                       @Param("newPassword") String newPassword);
}
