package com.material.user.web;

import com.material.user.entity.User;
import com.material.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import utils.Result;

/**
 * Created by Doing on 2016/12/20 0020.
 */
@Controller
@RequestMapping("/user")
public class UserPageController {

    @RequestMapping(value = "/page/all/",
            method = RequestMethod.GET)
    String getUserMainPage() {
        return "user_all";
    }

    @RequestMapping(value = "/page/add/",
            method = RequestMethod.GET)
    String getUserAddPage() {
        return "user_add";
    }
}
