package com.PhoneBook;

import javax.inject.Inject;
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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Contact> contacts = contactService.getAllContacts();
        // Отправка данных на страницу JSF для отображения
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Обработка создания, обновления или удаления контактов
    }
}
