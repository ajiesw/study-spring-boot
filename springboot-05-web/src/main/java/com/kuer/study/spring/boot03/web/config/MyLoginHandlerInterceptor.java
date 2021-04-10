package com.kuer.study.spring.boot03.web.config;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器
 * @author kuer
 */
public class MyLoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String user = (String)request.getSession().getAttribute("user");
        if (StringUtils.hasText(user)){
            return true;
        }
        else {
            request.setAttribute("msg", "请登录");
            request.getRequestDispatcher("/").forward(request, response);
            return false;
        }
    }
}
