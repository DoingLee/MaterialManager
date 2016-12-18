package com.material.order.dao;

import com.material.order.entity.Order;
import com.material.order.entity.UnsolvedOrderProductCount;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Doing on 2016/12/18 0018.
 */
public interface OrderDao {

    /**
     *  插入订单
     * @param order
     * @return
     */
    int insertOrder(Order order);

    /**
     * 获取所有订单
     * @return
     */
    List<Order> getAllOrder();

    /**
     *  更新订单状态
     * @param orderId  订单号
     * @param newStatus 新状态（unsolved solving solved）
     * @return
     */
    int updateOrderStatus(@Param("orderId")int orderId, @Param("newStatus") String newStatus);

    /**
     *  获取一个未处理的订单
     * @return
     */
    Order getUnsolvedOrder();

    /**
     * 获取所有未处理的订单产品总数
     * @return
     */
    List<UnsolvedOrderProductCount> getUnsolvedOrderProductCount();
}
