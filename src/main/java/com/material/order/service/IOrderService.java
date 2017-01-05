package com.material.order.service;

import com.material.order.dto.OrderMaterialDto;
import com.material.order.entity.Order;
import com.material.plan.dto.SingleProcessDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Doing on 2016/12/18 0018.
 */
public interface IOrderService {

    /**
     *  插入订单
     * @param order
     * @return
     */
    List<OrderMaterialDto> addOrder(Order order);

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
     * 获取一个产品的所有未处理订单
     * @return
     */
    List<Order> getUnsolvedOrders();
}
