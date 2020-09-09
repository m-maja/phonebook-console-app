package service;

import model.Contact;

import java.util.Map;

public interface ContactReader {
    Map<String, Contact> readContacts();
}
