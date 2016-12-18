package com.material.order.web;

import com.material.order.dto.OrderMaterialDto;
import com.material.order.entity.Order;
import com.material.order.service.IOrderService;
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

    @RequestMapping(value = "/",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    Result<List<OrderMaterialDto>> addOrder(Order order) {
        order.setStatus(Constants.ORDER_STATUS_UNSOLVED);

        List<OrderMaterialDto> orderMaterialDtos = orderService.addOrder(order);
        if (orderMaterialDtos != null){
            return new Result<List<OrderMaterialDto>>(true, orderMaterialDtos);
        }else {
            return new Result<List<OrderMaterialDto>>(false, null);
        }
    }

    @RequestMapping(value = "/all/",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    Result<List<Order>> getAllOrder() {
        List<Order> orders = orderService.getAllOrder();
        if (orders != null){
            return new Result<List<Order>>(true, orders);
        }else {
            return new Result<List<Order>>(false, null);
        }
    }

    @RequestMapping(value = "/{orderId}/status/",
            method = RequestMethod.PUT,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    Result<String> updateOrderStatus(@PathVariable("orderId")int orderId, @RequestParam("status")String newStatus) {
        int result = orderService.updateOrderStatus(orderId, newStatus);
        if (result == 1) {
            String s = "更新成功";
            return new Result<String>(true, s);
        }else {
            String s = "更新失败";
            return new Result<String>(false, s);
        }
    }

    @RequestMapping(value = "/1/unsolved/",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    Result<Order> getUnsolvedOrder() {
        Order order = orderService.getUnsolvedOrder();
        if (order != null) {
            return new Result<Order>(true, order);
        }else {
            return new Result<Order>(false, null);
        }
    }


}
