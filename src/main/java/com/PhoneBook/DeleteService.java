package com.PhoneBook;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class DeleteService {
    @Inject
    private ContactService contactService;

    public void deleteContact(Long contactId) {
        contactService.deleteContact(contactId);
    }
}
