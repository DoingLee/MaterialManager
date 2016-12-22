package com.material.order.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Doing on 2016/12/22 0022.
 */
@Controller
@RequestMapping("/order")
public class OrderPageController {

    @RequestMapping(value = "/page/check/",
            method = RequestMethod.GET)
    String checkOrderPage() {
        return "order_check";
    }
}
