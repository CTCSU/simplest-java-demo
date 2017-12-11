package com.SimplestDemo.SimplestMVC;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class HelloController {

    @RequestMapping("/hello")
    public String sayHello(){
        return "hello";
    }

}
