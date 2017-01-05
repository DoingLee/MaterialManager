package com.material.user.dao;

import com.material.user.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import utils.Constants;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Doing on 2016/12/16 0016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/application.xml"})
public class UserDaoTest {

    @Autowired
    UserDao userDao;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void testAddUser() {
        User user = new User(11115, "1234", "张三", "管理员");
        int result =  userDao.addUser(user);
        logger.debug("添加结果：" + result);
    }

    @Test
    public void testDeleteUser()  {
        int result = userDao.deleteUser(11115);
        logger.debug("删除结果：" + result);
    }

    @Test
    public void testGetUser()  {
        User user = userDao.getUser(11112);
        logger.debug("查询结果：" + user.toString());
    }

    @Test
    public void testGetAllUser()  {
        List<User> users = userDao.getAllUser();
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            logger.debug("查询结果：" + user.toString());
        }
    }

    @Test
    public void testUpdateUser()  {
        User user = new User(13333333, "1234", "李四", Constants.USER_TYPE_MANAGER);
        int result =  userDao.updateUser(user);
        logger.debug("更新结果：" + result);
    }
}