package com.fscsp.csp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("start")
public class TemplateController {
    @GetMapping("/login")
    public String getLoginView(){
        return "login";
    }

    @GetMapping("/loginSuccess")
    public String getLoginSuccessView(){
        return "loginSuccess";
    }
}
