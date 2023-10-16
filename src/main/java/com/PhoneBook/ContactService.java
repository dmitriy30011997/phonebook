package com.PhoneBook;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ContactService {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Contact> getAllContacts() {
        return entityManager.createQuery("SELECT c FROM Contact c", Contact.class).getResultList();
    }

    public void addContact(Contact contact) {
        entityManager.persist(contact);
    }

    public void deleteContact(Long contactId) {
        Contact contact = entityManager.find(Contact.class, contactId);
        if (contact != null) {
            entityManager.remove(contact);
        }
    }
}
