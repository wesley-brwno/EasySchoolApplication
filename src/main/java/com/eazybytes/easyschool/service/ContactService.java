package com.eazybytes.easyschool.service;

import com.eazybytes.easyschool.model.Contact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
    private static Logger log = LoggerFactory.getLogger(ContactService.class);
    public boolean saveMessageDetails(Contact contact) {
        boolean isSave = true;
        //TODO - need to persist the data into the DB table
        log.info(contact.toString());
        return  isSave;
    }
}
