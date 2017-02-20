package com.material.login.web;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import utils.Result;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Doing on 2016/12/20 0020.
 */
@Controller
@RequestMapping("/login")
public class LoginPageController {

    @RequestMapping(value = "/page/",
            method = RequestMethod.GET)
    String login() {
        return "login";
    }
}
