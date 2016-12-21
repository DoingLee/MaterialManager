package com.material.plan.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Doing on 2016/12/21 0021.
 */
@Controller
@RequestMapping("/plan")
public class PlanPageController {

    @RequestMapping(value = "/page/check/",
            method = RequestMethod.GET)
    String getPlanMainPage() {
        return "plan_check";
    }

    @RequestMapping(value = "/page/add/",
            method = RequestMethod.GET)
    String getPlanAddPage() {
        return "plan_add";
    }
}
