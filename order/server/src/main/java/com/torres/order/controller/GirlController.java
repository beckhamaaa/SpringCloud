package com.torres.order.controller;

import com.torres.order.config.GirlConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试yml文件前缀
 * Created by Torres
 * 2018-06-10 11:09
 */
@RestController
@RequestMapping("/girl")
public class GirlController {

    @Autowired
    private GirlConfig girlConfig;

    @GetMapping("/print")
    public String print() {
        return "name: " + girlConfig.getName() + " age: " + girlConfig.getAge();
    }
}
