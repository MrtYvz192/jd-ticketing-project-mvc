package com.cybertek.controller;

import com.cybertek.bootstrap.DataGenerator;
import com.cybertek.dto.UserDTO;
import com.cybertek.implementation.RoleServiceImpl;
import com.cybertek.implementation.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {


    DataGenerator dataGenerator;


    public UserController(DataGenerator dataGenerator) {
        this.dataGenerator = dataGenerator;
    }

    @GetMapping({"/create","/add"}) //==> multiple end points can be provided inside {}
    public String createUser(Model model){


        model.addAttribute("user",new UserDTO());
        model.addAttribute("users", dataGenerator.userService.findAll());
        model.addAttribute("roles", dataGenerator.roleService.findAll());
        return "user/create";
    }

    @PostMapping("/create")
    public String showList(@ModelAttribute("users") List<UserDTO> userList, Model model){
        model.addAttribute("users",userList);
        return "/user/create";
    }

}
