package com.cloud.api.api_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

/**
 * @Author:Controller
 * @date:2020-07-05 3:14 下午
 **/
@RestController
public class APIController {

    @GetMapping("/getHi")
    public String getHi(){
        return "hi ApiService";
    }

    @GetMapping("/getMap")
    public Map<String, String> getMap() {
        return Collections.singletonMap("id", "100");
    }
}
