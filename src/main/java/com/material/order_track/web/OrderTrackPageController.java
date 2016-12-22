package com.material.order_track.web;

import com.material.order_track.entity.OrderTrackMsg;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import utils.Result;

/**
 * Created by Doing on 2016/12/22 0022.
 */
@Controller
@RequestMapping("/order_track")
public class OrderTrackPageController {

    @RequestMapping(value = "/page/",
            method = RequestMethod.GET)
    String checkOrderTrackPage() {
        return "order_track";
    }
}
