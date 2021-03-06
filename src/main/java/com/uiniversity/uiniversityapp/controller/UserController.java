package com.uiniversity.uiniversityapp.controller;

import com.uiniversity.uiniversityapp.model.User;
import com.uiniversity.uiniversityapp.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/app")
public class UserController {
    
    @Autowired
    private UserService us;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public ModelAndView loginForm(@ModelAttribute User user) {
        ModelAndView mv = new ModelAndView();
        user = us.getUserByLogin(user.getLogin(), user.getPwd());
        if (user == null) {
            mv.setViewName("error");
        }
        else{
            mv.setViewName("userView");
        }
        mv.addObject("user", user);
        return mv;
    }

    @GetMapping(value="/user/{login}/{pwd}")
    public ModelAndView getUser(@PathVariable("login") String login,
                                @PathVariable("pwd") String pwd) {

        ModelAndView mv = new ModelAndView("userView");

        User user = us.getUserByLogin(login, pwd);
        
        mv.addObject("user", user);
        return mv;
    }
    
}