package com.person.hg.demo.config;

import com.person.hg.demo.intercepot.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 */
@Configuration
public class LoginConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册拦截器
        LoginInterceptor loginInterceptor = new LoginInterceptor();
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(loginInterceptor);

        // 拦截路径
        interceptorRegistration.addPathPatterns("/**");


        interceptorRegistration.excludePathPatterns("/noLogin");
        interceptorRegistration.excludePathPatterns("/");
        interceptorRegistration.excludePathPatterns("/login");
        interceptorRegistration.excludePathPatterns("/loginout");

        // 排除资源请求
        interceptorRegistration.excludePathPatterns("/css/login/*.css");
        interceptorRegistration.excludePathPatterns("/js/login/**/*.js");
        interceptorRegistration.excludePathPatterns("/image/login/*.png");
    }
}
