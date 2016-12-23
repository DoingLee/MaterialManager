package com.material.interceptor;

import com.material.login.dto.UserMsgDto;
import com.material.login.service.ILoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Doing on 2016/12/22 0022.
 */

/**
 * 用户管理员登录拦截类
 */
public class RootInterceptor implements HandlerInterceptor {

    @Autowired
    private ILoginService loginService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest,
                             HttpServletResponse httpServletResponse, Object o) throws Exception {
        Cookie[] cookies = httpServletRequest.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("key")) {
                String key = cookie.getValue();
                String accountId = key.substring(0, key.indexOf(":"));
                String md5Key = key.substring(key.indexOf(":") + 1);
                UserMsgDto userMsgDto = loginService.getUserMsg(Long.parseLong(accountId));
                String realRawKey = accountId + "fdsgadq2gll3#!@#15!@#" + userMsgDto.getPassword() + "root";
                String realMd5key = DigestUtils.md5DigestAsHex(realRawKey.getBytes()).toString();
                if (realMd5key.equals(md5Key)) {
                    return true;
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