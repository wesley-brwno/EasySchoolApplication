package com.eazybytes.eazyschool.controller;

import com.eazybytes.eazyschool.model.Person;
import com.eazybytes.eazyschool.repository.PersonRepository;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class DashboardContoller {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    private Environment environment;

    @Value("${eazyschool.pageSize}")
    private int defaultPageSize;

    @Value("${eazyschool.contact.successMsg}")
    private String message;

    @RequestMapping("/dashboard")
    public String displayDashboard(Model model, Authentication authentication, HttpSession session) {
        Person person = personRepository.readByEmail(authentication.getName());
        model.addAttribute("username", person.getName());
        model.addAttribute("roles", authentication.getAuthorities().toString());
        if(null != person.getEazyClass() && null != person.getEazyClass().getName()) {
            model.addAttribute("enrolledClass", person.getEazyClass().getName());
        }
        session.setAttribute("loggedInPerson", person);
        logMessages();
        return "dashboard.html";
    }

    private void logMessages() {
        log.error("Error message from the Dashboard page");
        log.warn("Warning message from the Dashboard page");
        log.info("Info message from teh Dashboard page");
        log.debug("Debug message from the Dashboard page");
        log.trace("Trace m essage from the Dashboard apage");

        log.error("defaultPageSize value with @Value annotation is : " + defaultPageSize);
        log.error("successMsg value with @Value annotation is : " + message);

        log.error("defaultPageSize value with Environment is :"+ environment.getProperty("eazyschool.pageSize"));
        log.error("--- ---" +environment.getProperty("eazyschool.contact.successMsg"));
        log.error(" -- --- "+ environment.getProperty("JAVA_HOME"));
    }
}
