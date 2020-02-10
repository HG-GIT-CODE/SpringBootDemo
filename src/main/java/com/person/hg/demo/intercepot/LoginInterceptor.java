package com.person.hg.demo.intercepot;

import com.person.hg.demo.model.SecuUser;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 是否登录账号
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Object user = request.getSession().getAttribute("user");
        if (null == user || !(user instanceof SecuUser)) {
            response.sendRedirect("/demo/");
            return false;
        } else {
            return true;
        }
    }
}
