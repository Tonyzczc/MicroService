package com.cloud.client.client_customer.controller;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

/**
 * @Author:Controller
 * @date:2020-07-05 3:29 下午
 **/
@RestController
public class MainController {

    @Autowired
    DiscoveryClient client;

    @Autowired
    LoadBalancerClient lb;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/client")
    public String client() {
        List<String> services = client.getServices();

        for (String str : services) {
            System.out.println(str);

        }
        return "Hi";
    }

    @GetMapping("/client2")
    public Object client2() {
        return client.getInstances("api-service");
    }

    @GetMapping("/client3")
    public Object client3() {

        List<ServiceInstance> instances = client.getInstances("api-service");
        for (ServiceInstance ins : instances) {
            System.out.println(ToStringBuilder.reflectionToString(ins));
        }
        return "xxoo";
    }

    @GetMapping("/client4")
    public Object client4() {

        // ribbon 完成客户端的负载均衡，过滤掉down了的节点
        ServiceInstance instance = lb.choose("api-service");

        String url ="http://" + instance.getHost() +":"+ instance.getPort() + "/getHi";

        String respStr = restTemplate.getForObject(url, String.class);

        System.out.println(respStr);
        return respStr;
    }

    @GetMapping("/client5")
    public Object client5() {
        // 自动处理URL
        String url ="http://api-service/getHi";

        String respStr = restTemplate.getForObject(url, String.class);

        System.out.println(respStr);
        return respStr;
    }

    @GetMapping("/client6")
    public Object client6() {
        // 自动处理URL
        String url ="http://api-service/getMap";
        Map<String,String> map = restTemplate.getForObject(url, Map.class);

        System.out.println(map);
        return map;
    }

}
