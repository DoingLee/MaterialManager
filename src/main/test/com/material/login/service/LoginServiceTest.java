package com.material.login.service;

import com.material.login.dao.LoginDao;
import com.material.login.dto.LoginMsgDto;
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
public class LoginServiceTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    LoginService loginService;

    @Test
    public void testGetPassword() throws Exception {
        LoginMsgDto t = loginService.checkPassword(11112, "13579");
        logger.debug("用户类型：" + t.toString());
    }

}