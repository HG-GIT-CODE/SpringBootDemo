package com.person.hg.demo.controller;

import com.person.hg.demo.model.SecuUser;
import com.suncreate.session.RedisSessionManager;
import com.suncreate.session.SessionManager;
import com.suncreate.session.StoreHttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexControllor {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    private SessionManager sessionManager;

    @RequestMapping("/")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response) {
        Map map = new HashMap();
        String userLogin = request.getParameter("userLogin");
        String userPassword = request.getParameter("userPassword");
        map.put("userLogin",userLogin);
        map.put("userPassword",userPassword);
        SecuUser user = new SecuUser();
        user.setUserLogin(userLogin);
        request.getSession().setAttribute("user",user);

        StoreHttpSession session = sessionManager.createEmptySession(request, response);
        session.setAttribute("user", user);
        sessionManager.saveSession(session, response);

        return "redirect:/city/getCity";
    }

    @RequestMapping("/noLogin")
    @ResponseBody
    public String noLogin() {
        return "您未登录！";
    }


}