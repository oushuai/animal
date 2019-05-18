package com.oushuai.animal.interceptor;

import com.oushuai.animal.bean.SysUser;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthorticateInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String returnUrl = request.getParameter("returnUrl");
        SysUser sysUser = (SysUser) request.getSession().getAttribute("sysUser");
        if (sysUser == null) {
            response.sendRedirect("/user/login?returnUrl="+request.getRequestURI());
            return false;
        }
        return true;
    }
}
