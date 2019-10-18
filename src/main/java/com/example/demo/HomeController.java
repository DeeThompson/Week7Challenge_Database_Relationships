package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    ATMRepository atmRepository;

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("atms", atmRepository.findAll());
        model.addAttribute("users", userRepository.findAll());

        return "index";

    }


    //=========user information====================================================

    @GetMapping("/balancelist")
    public String registrationForm(Model model) {
        model.addAttribute("user", new User());
        return "balancelist";

    }

    @GetMapping("/deposiform")
    public String depositForm(Model model) {
        model.addAttribute("user", new User());
        return "balancelist";

}


    @PostMapping("/process_deposit")
    public String depositForm (@Valid User user, BindingResult result){
        if (result.hasErrors()){
            return "depositform";
        }
        userRepository.save(user);

        return "redirect:/balancelist";
    }

    //=============ATM===============================
    @PostMapping("/process_withdrawal")
    public String processWithdrawalForm(@Valid ATM atm, BindingResult result){
        if (result.hasErrors()){
            return "withdrawalform";
        }
        atmRepository.save(atm);

        return "redirect:/balancelist";
    }


}


