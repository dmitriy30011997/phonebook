package com.PhoneBook;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/phonebook")
public class PhoneBookServlet extends HttpServlet {
    @Inject
    private ContactService contactService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Contact> contacts = contactService.getAllContacts();
        request.setAttribute("contacts", contacts);
        request.getRequestDispatcher("META-INF/maven/contacts.xhtml").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");

        if (action != null) {
            if (action.equals("delete")) {
                String contactId = request.getParameter("id");
                if (contactId != null) {
                    Long id = Long.parseLong(contactId);
                    contactService.deleteContact(id);
                }
            }
            response.sendRedirect(request.getContextPath() + "/contacts");
        }
    }
}