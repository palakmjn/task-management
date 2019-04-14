package com.project.taskmanagement.controllers;

import com.project.taskmanagement.commands.UserCommand;
import com.project.taskmanagement.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    
    // @Autowired
    private UserService userService;

    
    public UserController(UserService userService){
        this.userService=userService;
    }

    @RequestMapping("user/new")
    public String newUser(Model model){
        model.addAttribute("user",new UserCommand());
        return "user/userform";
    }
//check if url with users allowed?
    @RequestMapping("users/show")
    public String showUsers(Model model){
        model.addAttribute("user",userService.getUsers());
        return "user/users";
    }


    // //??
    // @PostMapping
    // @RequestMapping(name="user")
    // public String saveOrUpdate(@ModelAttribute UserCommand userCommand){//@ModelAttr binds form data to usercommand
    //     UserCommand savedCommand=userService.saveUserCommand(userCommand);
    //     return "redirect:user/users";
    // }


    @RequestMapping("user/{id}/show")
    public String showById(@PathVariable String id,Model model){
        model.addAttribute("user",userService.findById(new Long(id)));
        return "user/show";
    }

    @RequestMapping("user/{id}/update")
    public String updateById(@PathVariable String id,Model model){
        model.addAttribute("user",userService.findById(new Long(id)));

        return "user/userform";
    }

    @RequestMapping("user/{id}/delete")
    public String deleteById(@PathVariable String id){
        userService.deleteById(new Long(id));

        return "user/users";
    }

}
