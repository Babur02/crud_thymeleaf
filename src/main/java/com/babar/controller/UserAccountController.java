package com.babar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.babar.entities.UserAccount;

@Controller
public class UserAccountController {

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("user", new UserAccount());
        return "index";
    }
}
