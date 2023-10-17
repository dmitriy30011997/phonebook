package com.PhoneBook;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ContactRepository {

    public static List<Contact> getAllContacts(EntityManager entityManager) {
        TypedQuery<Contact> query = entityManager.createQuery("SELECT c FROM Contact c", Contact.class);
        return query.getResultList();
    }

    public static List<Contact> searchContacts(EntityManager entityManager, String searchTerm) {
        String queryStr = "SELECT c FROM Contact c " +
                "WHERE LOWER(c.firstName) LIKE :searchTerm " +
                "OR LOWER(c.lastName) LIKE :searchTerm " +
                "OR LOWER(c.phoneNumber) LIKE :searchTerm";
        TypedQuery<Contact> query = entityManager.createQuery(queryStr, Contact.class);
        query.setParameter("searchTerm", "%" + searchTerm.toLowerCase() + "%");
        return query.getResultList();
    }

    public static List<Contact> getSortedContacts(EntityManager entityManager) {
        TypedQuery<Contact> query = entityManager.createQuery("SELECT c FROM Contact c ORDER BY c.firstName, c.lastName", Contact.class);
        return query.getResultList();
    }
}
