package com.example.PBL.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "Chào mừng bạn đến với Spring Boot + Thymeleaf!");
        return "index"; // map tới index.html trong /templates
    }
}