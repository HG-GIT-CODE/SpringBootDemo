package com.person.hg.demo.config;

import com.person.hg.demo.intercepot.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 */
@Configuration
public class LoginConfig implements WebMvcConfigurer {

    // loginInterceptor已经HandlerInterceptor会在spring对象注入前加载，
    // 因此HandlerInterceptor中注入的@Autowired SessionManager sessionManager会是null
    // 所以在这里用@bean重新去装载LoginInterceptor这个对象，此时SessionManager就不是空了
    // 注意这里为什么
    @Bean
    public LoginInterceptor loginInterceptor() {
        return new LoginInterceptor();
    }




    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册拦截器


        LoginInterceptor loginInterceptor = loginInterceptor();
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(loginInterceptor);

        // 拦截路径
        interceptorRegistration.addPathPatterns("/**");

        // 不拦截哪些路径
        interceptorRegistration.excludePathPatterns("/");
        interceptorRegistration.excludePathPatterns("/login");
        interceptorRegistration.excludePathPatterns("/loginout");

        // springboot2.0 会拦截静态资源
        // 排除资源请求
        interceptorRegistration.excludePathPatterns("/static/*.png");


    }


}
