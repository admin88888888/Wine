package com.wine.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *@Author feri
 *@Date Created in 2019/4/29 10:50
 */
@Configuration
public class RedisConfig {
    @Bean
    public JedisUtil creteJu(){
        return new JedisUtil();
    }
}
