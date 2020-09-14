package com.ren.microservice_client.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author qiang.ren
 * @version 1.0
 * @since 2020/9/14 16:59
 */
@Controller
@RequestMapping("hello")
public class HelloWorldController {

    @GetMapping
    @ResponseBody
    public String hello() {
        return "Hello World.";
    }
}
