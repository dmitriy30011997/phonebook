package com.PhoneBook;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class SearchService {
    @Inject
    private ContactService contactService;

    public List<Contact> searchContacts(String searchTerm) {
        return contactService.searchContacts(searchTerm);
    }
}
