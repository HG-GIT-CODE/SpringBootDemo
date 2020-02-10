package com.person.hg.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 此类的作用是为了装载application.yum中druid的属性值
 */
@Configuration // 表示这是一个配置类，容器会加载
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource") // 装载application.yml中配置的值
    @Bean
    public DataSource druid() {
        return new DruidDataSource();
    }

    // 配置druid监控
    // 配置一个servlet管理后台
    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean bean =  new ServletRegistrationBean(new StatViewServlet(), "/druid/*");

        // 配置一些基本属性，属性名在statViewServlet的父类ResourceServlet中
        Map<String, String> initParameterMap = new HashMap<>();
        initParameterMap.put("loginUsername","hugang");
        initParameterMap.put("loginPassword","hugang");
        initParameterMap.put("allow",""); // 默认允许所有
        initParameterMap.put("deny","127.0.0.1"); // 拒绝

        bean.setInitParameters(initParameterMap);

        return bean;
    }

    // 配置一个web监控的filter
    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());

        Map<String, String> initParameterMap = new HashMap<>();
        initParameterMap.put("exclusions","*.js,*.css"); // 不拦截js css 这些静态文件

        bean.setInitParameters(initParameterMap);

        bean.setUrlPatterns(Arrays.asList("/*")); // 拦截所有请求
        return bean;
    }
}
