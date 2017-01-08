package com.material.order_track.dao;

import com.material.order_track.entity.OrderTrackMsg;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Doing on 2016/12/18 0018.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/application.xml"})
public class OrderTrackDaoTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    OrderTrackDao orderTrackDao;

    @Test
    public void testAddOrderTrack() throws Exception {
        OrderTrackMsg orderTrackMsg = new OrderTrackMsg("1", "张三", "获取订单");
        orderTrackDao.addOrderTrack(orderTrackMsg);
    }

    @Test
    public void testGetOrderTrack() throws Exception {
        List<OrderTrackMsg> orderTrackMsgs = orderTrackDao.getOrderTrack("5");
        for (OrderTrackMsg orderTrackMsg : orderTrackMsgs) {
            logger.debug(orderTrackMsg.toString());
        }
    }

    @Test
    public void testGetBeginDate() throws Exception {
        String d = orderTrackDao.getBeginDateTime("5", "^开始取料");
        logger.debug(d);
    }
}