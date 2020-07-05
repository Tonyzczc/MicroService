package com.cloud.client.client_customer.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @Author:Controller
 * @date:2020-07-05 3:26 下午
 **/
@Component
public class RibbonConfig {
    @Bean
    @LoadBalanced
    RestTemplate getRestTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate;
    }
}
