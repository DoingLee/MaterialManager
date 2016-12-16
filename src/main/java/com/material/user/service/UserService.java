package com.material.user.service;

import com.material.user.dao.UserDao;
import com.material.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Doing on 2016/12/16 0016.
 */
@Service
public class UserService implements IUserService {

    @Autowired
    UserDao userDao;

    public UserService() {
    }

    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public int deleteUser(long accountId) {
        return userDao.deleteUser(accountId);
    }

    @Override
    public User getUser(long accountId) {
        return userDao.getUser(accountId);
    }

    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }


    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }
}
