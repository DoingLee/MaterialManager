package com.material.order.service;

import com.material.inventory.dao.InventoryDao;
import com.material.inventory.entity.InventoryMaterial;
import com.material.order.dao.OrderDao;
import com.material.order.dto.OrderMaterialDto;
import com.material.order.entity.Order;
import com.material.plan.dao.PlanDao;
import com.material.plan.entity.ProductProcess;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Doing on 2016/12/18 0018.
 */
@Service
public class OrderService implements IOrderService {

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private InventoryDao inventoryDao;
    @Autowired
    private PlanDao planDao;

    public OrderService() {
    }

    @Override
    public List<OrderMaterialDto> addOrder(Order order) {
        int result = orderDao.insertOrder(order);
        if (result == 1) {
            List<ProductProcess> productProcesses = planDao.getProductProcess(order.getProductName());
            if (productProcesses == null) return null;

            List<OrderMaterialDto> orderMaterialDtos = new ArrayList<OrderMaterialDto>(productProcesses.size());
            for(ProductProcess productProcess : productProcesses){
                OrderMaterialDto orderMaterialDto = new OrderMaterialDto();
                orderMaterialDto.setMaterialName(productProcess.getMaterialName());
                orderMaterialDto.setWeight(productProcess.getWeight());
                InventoryMaterial inventoryMaterial = inventoryDao.getInventoryMaterial(productProcess.getMaterialName());
                orderMaterialDto.setLocation(inventoryMaterial.getLocation());

                orderMaterialDtos.add(orderMaterialDto);
            }
            return orderMaterialDtos;
        }else {
            return null;
        }
    }

    @Override
    public List<Order> getAllOrder() {
        return orderDao.getAllOrder();
    }

    @Override
    public int updateOrderStatus(int orderId, String newStatus) {
        return orderDao.updateOrderStatus(orderId, newStatus);
    }

    @Override
    public Order getUnsolvedOrder() {
        return orderDao.getUnsolvedOrder();
    }
}
