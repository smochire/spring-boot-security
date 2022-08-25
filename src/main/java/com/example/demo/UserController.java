package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private User user;


    @GetMapping("/login")
    public String login() {
        return "login";
    }


    @GetMapping("/user/login")
    public String UserLogin() {
        return "login";
    }

    @GetMapping("/home")
    public String hello() {
       if(user.getRole() == Role.ADMIN)
           return "redirect:/admin/home";
        return "hello";
    }

    @GetMapping("/admin/home")
    public String userHome() {
        return "hello";
    }

    public void setUser(User user)
    {
        this.user = user;
    }

}
