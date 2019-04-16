package com.boot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.domain.User;
import com.boot.service.UserService;


@Controller
@RequestMapping("")
public class WebController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/index")
    public String getIndex(Model model) {
        User user = userService.selectUserById(11);
        model.addAttribute("user", user);
        return "index";
    }
}
