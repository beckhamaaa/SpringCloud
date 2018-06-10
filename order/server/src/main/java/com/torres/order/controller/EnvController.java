package com.torres.order.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试 Bus 自动刷新
 * Created by Torres
 * 2018-06-02 23:12
 */
@RestController
@RequestMapping("/env")
@RefreshScope
//@Value 取不到值，要刷新作用域
public class EnvController {

    @Value("${env}")
    private String env;

    @GetMapping("/print")
    public String print() {
        return env;
    }
}
