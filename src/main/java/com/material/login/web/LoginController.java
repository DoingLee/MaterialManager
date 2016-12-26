package com.material.login.web;

import com.material.login.dto.LoginMsgDto;
import com.material.login.service.ILoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import utils.Result;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Doing on 2016/12/17 0017.
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private ILoginService loginService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    Result<String> login(@RequestParam("accountId") long accountId,
                         @RequestParam("password") String password,
                         @RequestParam("userType") String userType,
                         HttpServletResponse httpServletResponse,
                         HttpServletRequest request) throws IOException {

        LoginMsgDto loginMsgDto = loginService.checkPassword(accountId, password);
        if (loginMsgDto == null) {
            return new Result<String>(false, "密码错误！");
        }
        if (!userType.equals(loginMsgDto.getUserType())) {
            return new Result<String>(false, "用户权限错误！");
        }
        if (userType.equals("line_worker")) {
            return new Result<String>(true, loginMsgDto.getUserName());  //返回名字
        }

        String rawKey = accountId + "fdsgadq2gll3#!@#15!@#" + password + userType;
        String key = DigestUtils.md5DigestAsHex(rawKey.getBytes()).toString();
        Cookie cookie = new Cookie("key", accountId + ":" + key);
        cookie.setMaxAge(2592000);//30天
        cookie.setPath("/");
        httpServletResponse.addCookie(cookie);
        String url = getRedirectPageUrl(userType, request);
        return new Result<String>(true, url);
    }


    private String getRedirectPageUrl(String userType, HttpServletRequest request) {
        String host = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
        if (userType.equals("root")) {
            return host + "/user/page/all/";
        } else if (userType.equals("warehouse_manager")) {
            return host + "/order/page/check/";
        } else if (userType.equals("product_planner")) {
            return host + "/plan/page/check/";
        } else {
            return null;
        }
    }

    @RequestMapping(value = "/",
            method = RequestMethod.PUT,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    Result<String> updatePassword(@RequestParam("accountId") long accountId,
                                  @RequestParam("oldPassword") String oldPassword,
                                  @RequestParam("newPassword") String newPassword) {

        boolean isSuccess = loginService.updatePassword(accountId, oldPassword, newPassword);
        if (isSuccess) {
            String msg = "修改密码成功！";
            return new Result<String>(true, msg);
        } else {
            String msg = "更新密码失败！";
            return new Result<String>(false, msg);
        }
    }


}
