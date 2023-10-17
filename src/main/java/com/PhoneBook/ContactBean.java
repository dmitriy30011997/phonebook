package com.PhoneBook;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class ContactBean {
    @Inject
    private ContactService contactService;
    @Inject
    private SearchService searchService;
    @Inject
    private SortService sortService;
    @Inject
    private DeleteService deleteService;

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String searchTerm;

    public List<Contact> getContacts() {
        return contactService.getAllContacts();
    }

    public void addContact() {
        Contact newContact = new Contact();
        newContact.setFirstName(firstName);
        newContact.setLastName(lastName);
        newContact.setPhoneNumber(phoneNumber);
        contactService.addContact(newContact);
        // Сбросить поля после добавления контакта
        firstName = null;
        lastName = null;
        phoneNumber = null;
    }

    public void searchContacts() {
        List<Contact> searchResults = searchService.searchContacts(searchTerm);
    }

    public void sortContacts() {
        List<Contact> sortedContacts = sortService.getContactsSortedByName();
    }

    public void deleteContact(Long contactId) {
        deleteService.deleteContact(contactId);
    }
}
