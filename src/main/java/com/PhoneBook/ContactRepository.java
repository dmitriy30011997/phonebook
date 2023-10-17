package com.PhoneBook;

import javax.persistence.EntityManager;
import java.util.List;

public class ContactRepository {
    public static List<Contact> getAllContacts(EntityManager entityManager) {
        return entityManager.createQuery("SELECT c FROM Contact c", Contact.class).getResultList();
    }
}
