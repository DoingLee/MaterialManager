package com.material.interceptor;

/**
 * Created by Doing on 2016/12/23 0023.
 */

import com.material.login.dto.UserMsgDto;
import com.material.login.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 仓库管理员登录拦截类
 */
public class WareInterceptor implements HandlerInterceptor {
    @Autowired
    private ILoginService loginService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest,
                             HttpServletResponse httpServletResponse, Object o) throws Exception {
        Cookie[] cookies = httpServletRequest.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("key")) {
                    String key = cookie.getValue();
                    String accountId = key.substring(0, key.indexOf(":"));
                    String md5Key = key.substring(key.indexOf(":") + 1);
                    UserMsgDto userMsgDto = loginService.getUserMsg(Long.parseLong(accountId));

                    String realRawKey1 = accountId + "fdsgadq2gll3#!@#15!@#" + userMsgDto.getPassword() + "仓库管理员";
                    String realMd5key1 = DigestUtils.md5DigestAsHex(realRawKey1.getBytes()).toString();

                    String realRawKey2 = accountId + "fdsgadq2gll3#!@#15!@#" + userMsgDto.getPassword() + "管理员";
                    String realMd5key2 = DigestUtils.md5DigestAsHex(realRawKey2.getBytes()).toString();

                    String realRawKey3 = accountId + "fdsgadq2gll3#!@#15!@#" + userMsgDto.getPassword() + "超级管理员";
                    String realMd5key3 = DigestUtils.md5DigestAsHex(realRawKey3.getBytes()).toString();

                    if (realMd5key1.equals(md5Key) || realMd5key3.equals(md5Key) || realMd5key2.equals(md5Key)) {
                        return true;
                    }
                }
            }
        }
        //重定向到登录页面
        String host = httpServletRequest.getScheme() + "://" + httpServletRequest.getServerName() + ":" + httpServletRequest.getServerPort();
        httpServletResponse.sendRedirect(host + "/login/page/");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
