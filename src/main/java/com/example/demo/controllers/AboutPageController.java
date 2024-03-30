package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutPageController {
    @GetMapping("/about.html")
    public String about(Model theModel) {
        return "about.html";
    }
}
