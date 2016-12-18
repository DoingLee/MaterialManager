package com.material.order.dao;

import com.material.order.entity.Order;
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
 * Created by Doing on 2016/12/18 0018.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/application.xml"})
public class OrderDaoTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    OrderDao orderDao;

    @Test
    public void testInsertOrder() throws Exception {
        Order order = new Order("test0", 222, Constants.ORDER_STATUS_UNSOLVED, "张三", "199200");
        int r = orderDao.insertOrder(order);
        logger.debug("结果：" + r);
    }

    @Test
    public void testGetAllOrder() throws Exception {
        List<Order> orders = orderDao.getAllOrder();
        for (int i = 0; i < orders.size(); i++) {
            Order order = orders.get(i);
            logger.debug("所有订单：" + order.toString());
        }
    }

    @Test
    public void testUpdateOrderStatus() throws Exception {
        int r = orderDao.updateOrderStatus(2, Constants.ORDER_STATUS_SOLVING);
        logger.debug("结果：" + r);
    }

    @Test
    public void testGetUnsolvedOrder() throws Exception {
        Order order = orderDao.getUnsolvedOrder();
        if (order != null) {
            logger.debug("一个未处理订单：" + order.toString());
        } else {
            logger.debug("没有未处理订单");
        }
    }
}