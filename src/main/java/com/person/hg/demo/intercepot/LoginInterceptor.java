package com.person.hg.demo.intercepot;

import com.suncreate.session.SessionManager;
import com.suncreate.session.StoreHttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 是否登录账号
 */
public class LoginInterceptor implements HandlerInterceptor {
    // 此时的sessionManage为空，因为该类加载在spring对象注入前，因此调用时需要重新装载
    @Autowired
    SessionManager sessionManager;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String sessionId = sessionManager.getRequestedSessionId(request);
        StoreHttpSession session = sessionManager.loadSession(sessionId);
        if (null != session && session.getAttribute("user") != null) {
            return true;
        }else {
            response.sendRedirect("/demo/");
            return false;
        }
    }
}
