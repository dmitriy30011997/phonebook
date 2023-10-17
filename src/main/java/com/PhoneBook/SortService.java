package com.PhoneBook;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class SortService {
    @Inject
    private ContactService contactService;

    public List<Contact> getContactsSortedByName() {
        return contactService.getSortedContacts();
    }
}
