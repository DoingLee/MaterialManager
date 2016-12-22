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
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("key")) {
                String key = cookie.getValue();
                String accountId = key.substring(0, key.indexOf(":"));
                String md5Key = key.substring(key.indexOf(":") + 1);
                UserMsgDto userMsgDto = loginService.getUserMsg(new Long("accountId"));
                String realRawKey = accountId + "fdsgadq2gll3#!@#15!@#" + userMsgDto.getPassword() + "warehouse_manager";
                String realMd5key = DigestUtils.md5Digest(realRawKey.getBytes()).toString();
                if (realMd5key.equals(md5Key)) {
                    return false;
                }
            }
        }
        //重定向到登录页面
        String host = httpServletRequest.getScheme() + "://" + httpServletRequest.getServerName() + ":" + httpServletRequest.getServerPort();
        httpServletResponse.sendRedirect(host + "/login/page/");

        return true;
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
