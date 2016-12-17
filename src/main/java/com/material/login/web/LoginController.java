package com.material.login.web;

import com.material.login.dao.LoginDao;
import com.material.login.service.ILoginService;
import com.material.login.service.LoginService;
import com.material.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import utils.Result;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Doing on 2016/12/17 0017.
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private ILoginService loginService;

    @RequestMapping(value = "/{accountId}/",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    Result<String> login(@PathVariable("accountId") long accountId, @RequestParam("password") String password,
                         HttpServletResponse httpServletResponse) {

        boolean isSuccess = loginService.checkPassword(accountId, password);
        if (isSuccess) {
            String rawKey = accountId + "fdsgadq2gll3#!@#15!@#" + password;
            String key = DigestUtils.md5Digest(rawKey.getBytes()).toString();
            Cookie cookie = new Cookie("key", key);
            cookie.setMaxAge(2592000);//30天
            httpServletResponse.addCookie(cookie);

            String msg = "登录成功！";
            return new Result<String>(true, msg);
        } else {
            String msg = "登录失败！";
            return new Result<String>(false, msg);
        }
    }

    @RequestMapping(value = "/{accountId}/",
            method = RequestMethod.PUT,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    Result<String> updatePassword(@PathVariable("accountId") long accountId,
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
