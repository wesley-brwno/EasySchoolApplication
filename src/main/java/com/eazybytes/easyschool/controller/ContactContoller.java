package com.eazybytes.easyschool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContactContoller {

    @RequestMapping("/contact")
    public String displayContactPage() {
        return "contact.html";
    }
}
