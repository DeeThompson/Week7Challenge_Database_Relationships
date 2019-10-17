package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    ATMRepository atmRepository;

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/")
    public String home(Model model){
        model.addAttribute("atms", atmRepository.findAll());
        model.addAttribute("users", userRepository.findAll());

        return "index";

    }

        //=========user information====================================================

    @GetMapping("/adduser")
    public String userForm(Model model){
        model.addAttribute("user", new User());
        return "userform";




}
