package com.material.user.service;

import com.material.user.entity.User;

import java.util.List;

/**
 * Created by Doing on 2016/12/16 0016.
 */
public interface IUserService {

    /**
     *
     * @param user
     * @return 1：添加成功； 0：重复添加
     */
    int addUser(User user);

    /**
     *
     * @param accountId
     * @return 1：删除成功； 0：用户不存在
     */
    int deleteUser(long accountId);

    /**
     *
     * @param accountId
     * @return
     */
    User getUser(long accountId);

    /**
     *
     * @return
     */
    List<User> getAllUser();

    /**
     *
     * @param user
     * @return 1：更新成功； 0：用户不存在
     */
    int updateUser(User user);

}
