package com.cybertek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping({"/create","/add"}) //==> multiple end points can be provided inside {}
    public String createUser(){

        return "user/create";
    }


}
