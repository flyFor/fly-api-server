package com.github.flyfor.config;

import com.github.flyfor.controller.IndexController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created on 2017. 8. 26..
 */
@Configuration
public class ApiServerConfig {

    @Bean
    public IndexController indexController() {
        IndexController bean = new IndexController();
        return bean;
    }
}
