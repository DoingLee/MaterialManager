package com.material.user.dao;

import com.material.user.entity.User;

import java.util.List;

/**
 * Created by Doing on 2016/12/16 0016.
 */
public interface UserDao {

    int addUser(User user);

    int deleteUser(long accountId);

    User getUser(long accountId);

    List<User>  getAllUser();

    int updateUser(User user);

}
