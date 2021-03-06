package com.material.order.web;

import com.material.inventory.service.IInventoryService;
import com.material.order.dto.OrderMaterialDto;
import com.material.order.entity.Order;
import com.material.order.service.IOrderService;
import com.material.plan.dto.SingleProcessDto;
import com.material.plan.service.IPlanService;
import com.material.user.entity.User;
import com.material.user.service.IUserService;
import com.sun.org.glassfish.gmbal.ParameterNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import utils.Constants;
import utils.Result;

import java.util.List;

/**
 * Created by Doing on 2016/12/18 0018.
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private IOrderService orderService;
    @Autowired
    private IPlanService planService;
    @Autowired
    private IInventoryService inventoryService;

    @RequestMapping(value = "/",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    Result<List<OrderMaterialDto>> addOrder(Order order) {
        order.setStatus(Constants.ORDER_STATUS_UNSOLVED);

        List<OrderMaterialDto> orderMaterialDtos = orderService.addOrder(order);
        if (orderMaterialDtos != null) {
            return new Result<List<OrderMaterialDto>>(true, orderMaterialDtos);
        } else {
            return new Result<List<OrderMaterialDto>>(false, null);
        }
    }

    @RequestMapping(value = "/all/",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    Result<List<Order>> getAllOrder() {
        List<Order> orders = orderService.getAllOrder();
        if (orders != null) {
            return new Result<List<Order>>(true, orders);
        } else {
            return new Result<List<Order>>(false, null);
        }
    }

    @RequestMapping(value = "/{orderId}/status/",
            method = RequestMethod.PUT,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    Result<String> updateOrderStatus(@PathVariable("orderId") String orderId, @RequestParam("status") String newStatus) {
        int result = orderService.updateOrderStatus(orderId, newStatus);
        if (result == 1) {
            String s = "更新成功";
            return new Result<String>(true, s);
        } else {
            String s = "更新失败";
            return new Result<String>(false, s);
        }
    }

    /**
     * 获取未处理的产品订单（合并）
     *
     * @return
     */
    @RequestMapping(value = "/unsolved/",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    Result<List<Order>> getUnsolvedOrder() {
        //获取一个产品的所有未处理订单
        List<Order> orders = orderService.getUnsolvedOrders();
        
        if (orders == null) {
            return new Result<List<Order>>(false, null);
        }

        for (Order order : orders) {
            //更新订单状态为正在取料
            int result = orderService.updateOrderStatus(order.getOrderId(), Constants.ORDER_STATUS_COLLECTING);
            //减库存
            List<SingleProcessDto> singleProcessDtos = planService.getProductProcess(order.getProductName());
            for (SingleProcessDto singleProcessDto : singleProcessDtos) {
                inventoryService.addInventoryMaterialWeight(singleProcessDto.getMaterialName(), -singleProcessDto.getWeight());
            }
        }

        return new Result<List<Order>>(true, orders);

    }


}
