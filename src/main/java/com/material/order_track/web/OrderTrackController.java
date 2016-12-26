package com.material.order_track.web;

import com.material.order.service.IOrderService;
import com.material.order_track.entity.OrderTrackMsg;
import com.material.order_track.service.IOrderTrackService;
import com.material.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import utils.Constants;
import utils.Result;

import java.util.List;

/**
 * Created by Doing on 2016/12/18 0018.
 */
@Controller
@RequestMapping("/order_track")
public class OrderTrackController {

    @Autowired
    private IOrderTrackService orderTrackService;
    @Autowired
    private IOrderService orderService;

    @RequestMapping(value = "/",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    Result<String> addOrderTrack(OrderTrackMsg orderTrackMsg){
        int result = orderTrackService.addOrderTrack(orderTrackMsg);

        if (orderTrackMsg.getAction().equals("完成订单")) {
            orderService.updateOrderStatus(orderTrackMsg.getOrderId(), Constants.ORDER_STATUS_SOLED);
        }

        if (result == 1){
            String msg = "添加成功！";
            return new Result<String>(true, msg);
        }else {
            String msg = "添加失败！";
            return new Result<String>(false, msg);
        }
    }

    @RequestMapping(value = "/{orderId}/",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    Result<List<OrderTrackMsg>> getOrderTrack(@PathVariable("orderId")int orderId){
        List<OrderTrackMsg> result = orderTrackService.getOrderTrack(orderId);
        if (result != null){
            return new Result<List<OrderTrackMsg>>(true, result);
        }else {
            return new Result<List<OrderTrackMsg>>(false, null);
        }
    }
}
