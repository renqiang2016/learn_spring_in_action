package com.ren.learn_spring_in_action.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author qiang.ren
 * @version 1.0
 * @since 2020/9/1 11:14
 */
@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";
    }
}
