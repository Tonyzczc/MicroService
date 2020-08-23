package com.cloud.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "api-service")
public interface ServiceForecast {

    @RequestMapping(value = "/getHi",method = RequestMethod.GET)
    public String forecast();
}
