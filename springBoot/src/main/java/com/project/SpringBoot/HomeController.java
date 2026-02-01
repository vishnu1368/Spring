package com.project.SpringBoot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
@Controller vs @RestController
    Controller excepts a layout() but with RestController we can transfer anything from client to Server.
If you want to do with @Controller, then instead of returning the layout. You can choose to return only the data through @ResponseBody
 */
@Controller
public class HomeController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello.html";
    }
}
