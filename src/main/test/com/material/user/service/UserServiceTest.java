package com.material.user.service;

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
public class UserServiceTest {

    @Autowired
    UserService userService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void testAddUser() throws Exception {
        User user = new User(13333333, "1234", "张三", Constants.USER_TYPE_ROOT);
        int result =  userService.addUser(user);
        logger.debug("添加结果：" + result);
    }

    @Test
    public void testDeleteUser() throws Exception {
        int result = userService.deleteUser(13333333);
        logger.debug("删除结果：" + result);
    }

    @Test
    public void testGetUser() throws Exception {
        User user = userService.getUser(13333333);
        logger.debug("查询结果：" + user.toString());
    }

    @Test
    public void testGetAllUser() throws Exception {
        List<User> users = userService.getAllUser();
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            logger.debug("查询结果：" + user.toString());
        }
    }

    @Test
    public void testUpdateUser() throws Exception {
        User user = new User(13333333, "12345", "李四", Constants.USER_TYPE_ROOT);
        int result =  userService.updateUser(user);
        logger.debug("更新结果：" + result);
    }
}