package com.eazybytes.easyschool.controller;

import com.eazybytes.easyschool.model.Contact;
import com.eazybytes.easyschool.service.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class ContactContoller {
    private final ContactService contactService;

    @Autowired
    public ContactContoller(ContactService contactService) {
        this.contactService = contactService;
    }
    @RequestMapping("/contact")
    public String displayContactPage() {
        return "contact.html";
    }

//    @PostMapping(value= "/saveMsg")
//    public ModelAndView saveMessage(@RequestParam String name, @RequestParam String mobileNum,
//                                    @RequestParam String email, @RequestParam String subject,
//                                    @RequestParam String message) {
//
//        log.info("Name : " + name);
//        log.info("Mobile Numer : " + mobileNum);
//        log.info("Email Address : " + email);
//        log.info("Subject : " + subject);
//        log.info("Message : " + message);
//        return new ModelAndView("redirect:/contact");
//    }

    @PostMapping(value = "/saveMsg")
    public  ModelAndView saveMessage(Contact contact) {
        contactService.saveMessageDetails(contact);
        return new ModelAndView("redirect:/contact");
    }
}
