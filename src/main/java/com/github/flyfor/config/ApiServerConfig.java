package com.github.flyfor.config;

import com.github.flyfor.controller.IndexController;
import com.github.flyfor.service.ExternalApiService;
import com.github.flyfor.service.ExternalApiServiceImpl;
import com.github.flyfor.util.HttpClientProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * Created on 2017. 8. 26..
 */
@Configuration
public class ApiServerConfig {

    @Autowired
    Environment env;

    @Bean
    public HttpClientProxy httpClientProxy() {
        HttpClientProxy bean = new HttpClientProxy();
        return bean;
    }

    @Bean
    public ExternalApiService externalApiService() {
        ExternalApiServiceImpl bean = new ExternalApiServiceImpl();
        bean.setHttpClientProxy(httpClientProxy());
        bean.setExternalApiHost(env.getProperty("external.api.path"));
        bean.setExternalApiToken(env.getProperty("external.api.token"));
        return bean;
    }

    @Bean
    public IndexController indexController() {
        IndexController bean = new IndexController();
        return bean;
    }
}
