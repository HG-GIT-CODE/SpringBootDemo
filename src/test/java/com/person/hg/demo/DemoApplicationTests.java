package com.person.hg.demo;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    DataSource dataSource;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;


    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    void contextLoads() {


    }

    /**
     * 测试datasource数据源
     */
    @Test
    public void dataSourceTest() throws Exception{
        Connection connection = dataSource.getConnection();
        System.out.println(connection);


        BoundValueOperations<String, String> stringStringBoundValueOperations = stringRedisTemplate.boundValueOps("111");
        stringStringBoundValueOperations.append("222");
        connection.close();
    }
}
