package com.material.login.dao;

import com.material.login.entity.LoginMsg;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by Doing on 2016/12/17 0017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/application.xml"})
public class LoginDaoTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    LoginDao loginDao;

    @Test
    public void testGetUserLoginMsg() throws Exception {
        LoginMsg p = loginDao.getUserLoginMsg(11112);
        logger.debug("密码：" + p.toString());
    }

    @Test
    public void testUpdatePassword() throws Exception {
        int result = loginDao.updatePassword(11113, "13579", "1234");
        logger.debug("更新状态：" + result);
    }
}