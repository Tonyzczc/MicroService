package com.cloud.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:Controller
 * @date:2020-08-18 11:10 下午
 **/
@RestController
public class Controller {
    @Autowired
    private ServiceForecast serviceForecast;

    @RequestMapping("test")
    public void test(){
        String test = serviceForecast.forecast();
        System.out.println(test);
    }


}
