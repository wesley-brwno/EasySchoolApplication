package com.eazybytes.easyschool.service;

import com.eazybytes.easyschool.model.Contact;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ContactService {
    public boolean saveMessageDetails(Contact contact) {
        boolean isSave = true;
        //TODO - need to persist the data into the DB table
        log.info(contact.toString());
        return  isSave;
    }
}
