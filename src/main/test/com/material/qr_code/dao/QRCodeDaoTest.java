package com.material.qr_code.dao;

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
public class QRCodeDaoTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    QRCodeDao qrCodeDao;

    @Test
    public void testAddMaterialName() throws Exception {
        int result = qrCodeDao.addMaterialName("m0");
        logger.debug("结果：" + result);
    }

    @Test
    public void testAddBlenderName() throws Exception {
        int result = qrCodeDao.addBlenderName("b0");
        logger.debug("结果：" + result);
    }
}