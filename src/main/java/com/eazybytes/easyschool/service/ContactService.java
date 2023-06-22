package com.eazybytes.easyschool.service;

import com.eazybytes.easyschool.model.Contact;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

@Slf4j
@Service
//@RequestScope
//@SessionScope
//@ApplicationScope
public class ContactService {

    private int counter = 0;

    public ContactService() {
        System.out.println("Couneter Service Bean initialized");
    }

    public boolean saveMessageDetails(Contact contact) {
        boolean isSave = true;
        //TODO - need to persist the data into the DB table
        log.info(contact.toString());
        return  isSave;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
