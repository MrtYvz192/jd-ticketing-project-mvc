package com.cybertek.controller;

import com.cybertek.bootstrap.DataGenerator;
import com.cybertek.dto.RoleDTO;
import com.cybertek.dto.UserDTO;
import com.cybertek.implementation.RoleServiceImpl;
import com.cybertek.implementation.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String insertUser(UserDTO user, Model model){

        dataGenerator.userService.save(user);

        model.addAttribute("user",new UserDTO());
        model.addAttribute("roles", dataGenerator.roleService.findAll());
        model.addAttribute("users", dataGenerator.userService.findAll());
        return "/user/create";
    }

    @GetMapping("update/{username}")
    public String editUser(@PathVariable("username") String username, Model model){

        model.addAttribute("user", dataGenerator.userService.findBYId(username));
        model.addAttribute("users", dataGenerator.userService.findAll());
        model.addAttribute("roles", dataGenerator.roleService.findAll());

        return "user/update";
    }

    @PostMapping("/update/{username}")
    public String updateUser(@PathVariable("username") String username, UserDTO user, Model model){

        dataGenerator.userService.deleteById(username);
        dataGenerator.userService.update(user);

        model.addAttribute("user",new UserDTO());
        model.addAttribute("roles", dataGenerator.roleService.findAll());
        model.addAttribute("users", dataGenerator.userService.findAll());



        return "user/create";
    }

}
